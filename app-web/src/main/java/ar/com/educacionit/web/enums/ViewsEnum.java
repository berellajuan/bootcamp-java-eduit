package ar.com.educacionit.web.enums;

public enum ViewsEnum {
	//valores posibles // Key(valor)
	LISTADO("list"),
	LOGIN("login"),
	ALTA("alta"),
	REGISTRO_OK("/registroOk.jsp"),
	REGISTRO_FAIL("/registroFail.jsp");
	
	//CTR + SHIFT + Y MINUSCULA   O  X MAYUSCULA
	private String value;
	
	private ViewsEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return this.value;
	}
}
