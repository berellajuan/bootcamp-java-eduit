package clase11;

public class EmailLog extends Log {

	public EmailLog(String msj) {
		super(msj);
	}

	@Override
	public void loguear() {
		System.out.println("Enviando email");
	}

}
