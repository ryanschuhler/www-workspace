package spicy.tomato;

import java.util.ArrayList;
import java.util.List;

public class Structure {

	public Structure(String groupName, String structureKey, String content) {
		_groupName = groupName;
		_structureKey = structureKey;
		_templates = new ArrayList<Template>();
		
		_content = content;
	}
	
	public void addTemplate(Template template) {
		_templates.add(template);
	}
	
	public String getContent() {
		return _content;
	}

	public String getGroupName() {
		return _groupName;
	}


	public String getStructureKey() {
		return _structureKey;
	}

	public List<Template> getTemplates() {
		return _templates;
	}
	
	private String _content;
	private String _groupName;
	private String _structureKey;
	private List<Template> _templates;
	
}
