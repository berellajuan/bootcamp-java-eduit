package clase14;

public class Italiano implements IIDioma{

	
	public void decir() {
		System.out.println("io parlare italiano");
		
	}
	@Override
	public void decir(String hablar) {
		System.out.println("Parlando: "+hablar);
	}


}
