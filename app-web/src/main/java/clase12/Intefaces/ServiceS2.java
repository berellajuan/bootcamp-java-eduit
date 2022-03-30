package clase12.Intefaces;

public class ServiceS2 implements IService {

	@Override
	public Dato consultar() {
		String res = "id0001nombrecarlos     saldo01550";
		
		//subString(Start,End)
		String idStr = res.substring(2, 6);
		String nombreStr = res.substring(12,22);
		//nombreStr = nombreStr.trim();
		String saldoStr = res.substring(res.length()-5,res.length());
		
		
		return new Dato(Long.parseLong(idStr),nombreStr);
	}
	
	

}
