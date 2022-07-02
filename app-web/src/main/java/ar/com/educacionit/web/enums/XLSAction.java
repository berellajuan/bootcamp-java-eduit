package ar.com.educacionit.web.enums;

public class XLSAction implements IFormato {
	
	@Override
	public void doAction() {
		System.out.println("Convirtiendo a "+ getClass().getCanonicalName());

	}

}
