package clase11;

public class MainLog {

	public static void main(String[] args) {
		
		String op = "1";//fs 2; email
		String msj = "mensaje a enviar";
		
		System.out.println("Ingrese la cantidad de log");
		int cantidad = 2;
		
		Log[] log = new Log[cantidad];
		
		Log aux = getLog(op,msj);
		
	
		
	}
	
	
	public static Log getLog(String op, String msj) {
		Log res;
		if(op.equals("1")) {
			res = new FSLog(msj);
		}else if(op.equals("2")) {
			res = new EmailLog(msj);
		}else {
			res = new DefaultLog(msj);
		}
		return res;
		
	}

}
