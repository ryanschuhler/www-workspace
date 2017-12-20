package spicy.tomato;

import com.liferay.portal.kernel.util.StringParser;
import com.liferay.portal.kernel.util.StringUtil;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

import org.osgi.framework.Bundle;
import org.osgi.framework.BundleContext;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;

/**
 * @author Joan H. Kim
 */
@Component(
	immediate = true,
	service = Incinerate.class
)
public class IncinerateImpl implements Incinerate {

	@Override
	public void sayHello() {
		System.out.println("Hello World!");
	}
	
	protected void iterateEntryPaths(Bundle bundle, String pathToSearch) throws IOException {
		Enumeration<String> paths = bundle.getEntryPaths(pathToSearch);
		
		if (paths != null) {
			while (paths.hasMoreElements()) {
	
				String path = (paths.nextElement());
				
			    System.out.println(path);
			    
			    URL url = bundle.getEntry(path);		
			    Object obj = url.getContent();
			    System.out.println(obj);
			    iterateEntryPaths(bundle, path);
			}
		}
	}

	protected InputStream getInputStream(URL url) throws Exception {


		return new BufferedInputStream(url.openStream());
	}
	
	
	public void test(String path) {
		
		
		StringParser stringParser = StringParser.create(
				//"{fileentry:[^/]+}//{directory:[^/]+}/{ddm}/{groupName}/{structureKey}/{filename}");
				"{fileentry:[^/]+}//{directory:[^/]+}/{ddm:[^/]+}/{groupName:[^/]+}/{structureKey:[^/]+}/{filename:[^$]+}");

		
			//    bundleentry://549.fwk1886954700/ddm/guest/button/button.json
			
		//path = "bundleentry://549.fwk1886954700/ddm/123/abc/xyz";
		//StringParser stringParser = StringParser.create(
		//"/{ddm}/{groupName}/{structureKey}/{filename}");
		/*StringParser stringParser = StringParser.create(
				"{protocol}://{dir}/{ddm}/{groupName}/{structureKey}/{filename}");
*/
		//  bundleentry://549.fwk1886954700/ddm/guest/heading/heading.json
			Map<String, String> params = new HashMap<>();
			System.out.println("checking" + path);
			stringParser.parse(path, params);

			for (String key :  params.keySet()) {
				
				System.out.println(key + ": " + params.get(key));
			}
	}
	
	@Activate
	protected void activate(BundleContext bundleContext) {
		
		Bundle bundle = bundleContext.getBundle();
		
		try {
			
			Enumeration<URL> structures = bundle.findEntries("/ddm", "*.json", true);
			
			while (structures.hasMoreElements()) {

				
				URL structure = structures.nextElement();  
				test(structure.toString());
				String content = StringUtil.read(getInputStream(structure));

			    System.out.println(structure + content);   
			}
			
			Enumeration<URL> templates = bundle.findEntries("/ddm", "*.ftl", true);
			
			while (templates.hasMoreElements()) {

				URL template = templates.nextElement();
			    System.out.println(template);   
			}
			
			//iterateEntryPaths(bundle, "/ddm");
			
			/*
			
			Enumeration<String> paths = bundle.getEntryPaths("/ddm");
			while (paths.hasMoreElements()) {

				String path = (paths.nextElement());
				
			    System.out.println(path);
			    
			    URL url = bundle.getEntry(path);
			    
			    
			    System.out.println("prototcaol" + url.getProtocol());
			    if (url != null && url.getProtocol().equals("file")) {
			        
			        URI uri = url.toURI();
			        System.out.println(uri);
			        File file = new File(uri);
			        String[] lists = file.list();
			        for (String list : lists) {
			        		System.out.println("found" + list);
			        }
			      } 
			    
			    
			 
			}
			  */
		} catch (Exception e) {
			System.out.println(e.toString());
			System.out.println("yowzers");
		}
		
	}
	
	String[] getResourceListing(Class clazz, String path) throws URISyntaxException, IOException {
	      URL dirURL = clazz.getClassLoader().getResource(path);
	      if (dirURL != null && dirURL.getProtocol().equals("file")) {
	        /* A file path: easy enough */
	        return new File(dirURL.toURI()).list();
	      } 

	      if (dirURL == null) {
	        /* 
	         * In case of a jar file, we can't actually find a directory.
	         * Have to assume the same jar as clazz.
	         */
	        String me = clazz.getName().replace(".", "/")+".class";
	        dirURL = clazz.getClassLoader().getResource(me);
	      }
	      
	      if (dirURL.getProtocol().equals("jar")) {
	        /* A JAR path */
	        String jarPath = dirURL.getPath().substring(5, dirURL.getPath().indexOf("!")); //strip out only the JAR file
	        JarFile jar = new JarFile(URLDecoder.decode(jarPath, "UTF-8"));
	        Enumeration<JarEntry> entries = jar.entries(); //gives ALL entries in jar
	        Set<String> result = new HashSet<String>(); //avoid duplicates in case it is a subdirectory
	        while(entries.hasMoreElements()) {
	          String name = entries.nextElement().getName();
	          if (name.startsWith(path)) { //filter according to the path
	            String entry = name.substring(path.length());
	            int checkSubdir = entry.indexOf("/");
	            if (checkSubdir >= 0) {
	              // if it is a subdirectory, we just return the directory name
	              entry = entry.substring(0, checkSubdir);
	            }
	            result.add(entry);
	          }
	        }
	        return result.toArray(new String[result.size()]);
	      } 
	        
	      throw new UnsupportedOperationException("Cannot list files for URL "+dirURL);
	  }

/*
	
	protected void addDDMStructures(String dirName) throws Exception {
		File dir = new File(_resourcesDir, dirName);

		if (!dir.isDirectory() || !dir.canRead()) {
			return;
		}

		File[] files = listFiles(dir);

		for (File file : files) {
			String fileName = FileUtil.stripExtension(file.getName());

			addDDMStructures(fileName, getInputStream(file));
		}
	}
*/
}