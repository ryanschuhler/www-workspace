package spicy.tomato;

import java.util.ArrayList;
import java.util.List;

public class Structure {

	public Structure(String groupKey, String structureKey, String content) {
		_content = content;
		_groupKey = groupKey;
		_structureKey = structureKey;
		_templates = new ArrayList<>();
	}

	public void addTemplate(Template template) {
		_templates.add(template);
	}

	public String getContent() {
		return _content;
	}

	public String getGroupKey() {
		return _groupKey;
	}

	public String getStructureKey() {
		return _structureKey;
	}

	public List<Template> getTemplates() {
		return _templates;
	}

	private String _content;
	private String _groupKey;
	private String _structureKey;
	private List<Template> _templates;

}