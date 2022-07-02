package ar.com.educacionit.web.enums;

public enum AttributeEnum {
	ARTICULOS("articulos");
	
	private String key;

	private AttributeEnum(String key) {
		this.key = key;
	}
	
	public String getValue() {
		return this.key;
	}
}
