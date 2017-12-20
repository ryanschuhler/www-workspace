package spicy.tomato;

import java.util.ArrayList;
import java.util.List;

public class Structure {

	public Structure(
		String groupKey, String structureKey, String name, String content) {

		_content = content;
		_groupKey = groupKey;
		_name = name;
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

	public String getName() {
		return _name;
	}

	public String getStructureKey() {
		return _structureKey;
	}

	public List<Template> getTemplates() {
		return _templates;
	}

	private String _content;
	private String _groupKey;
	private String _name;
	private String _structureKey;
	private List<Template> _templates;

}