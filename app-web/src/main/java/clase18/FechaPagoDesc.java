package clase18;

public class FechaPagoDesc extends FechaPagoComparator {

	public int comparar(Cheque c1, Cheque c2) {
		return c2.getFechaPago().compareTo(c1.getFechaPago()); 
	}

	@Override
	public int compare(Cheque o1, Cheque o2) {
		// TODO Auto-generated method stub
		return 0;
	}
}
