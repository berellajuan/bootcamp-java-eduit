package clase11;

public abstract class Log {

	private String msj;

	public Log(String msj) {
		this.msj = msj;
	}
	
	public abstract void loguear();

	public String getMsj() {
		String msj;
		if(this.msj == null) {
			msj = "";
		}else {
			msj = this.msj;
		}
		return msj;
	}

	public void setMsj(String msj) {
		this.msj = msj;
	}
	
}
