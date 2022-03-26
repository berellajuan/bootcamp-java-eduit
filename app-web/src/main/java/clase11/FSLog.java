package clase11;

public class FSLog extends Log {

	public FSLog(String msj) {
		super(msj);
	}

	@Override
	public void loguear() {
		System.out.println("Escribiendo en c:/" + this.getMsj());
	}

}
