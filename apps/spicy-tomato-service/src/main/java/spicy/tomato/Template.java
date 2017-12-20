package spicy.tomato;

public class Template {

	public Template(String templateName, String content) {
		_templateName = templateName;
		
		_content = content;
	}
	
	public String getContent() {
		return _content;
	}
	
	public String getTemplateName() {
		return _templateName;
	}
	
	private String _content;
	private String _templateName;
	
}
