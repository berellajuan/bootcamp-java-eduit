package ar.com.educacionit.services.exceptions;

public class ParseException extends Exception {
	//serializable -> Sirve para identificar las clases con un identificador unico
	public ParseException(String string) {
		super(string);
	}

	public ParseException(String string, Throwable e) {
		super(string,e);
	}

}
