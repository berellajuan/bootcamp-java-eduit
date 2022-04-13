package clase18;

public class FechaPagoBanco extends FechaPagoComparator {

	@Override
	public int comparar(Cheque c1, Cheque c2) {
		int resta=0;
		if(c1.getFechaPago().equals(c2.getFechaPago()) ) {
			resta = c1.getBanco().compareTo(c2.getBanco());
		}
		
		return resta;
		

	}

	@Override
	public int compare(Cheque o1, Cheque o2) {
		// TODO Auto-generated method stub
		return 0;
	}

}
