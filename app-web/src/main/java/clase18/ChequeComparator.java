package clase18;

import java.util.Comparator;

public abstract class ChequeComparator implements Comparator<Cheque>{

	@Override
	public int compare(Cheque c1, Cheque c2) {
		int resta;
		if(c1 == null || c2 == null) {
			resta=0;
		}
		if(c1 == c2) {
			resta=0;
		}
		
		resta = this.comparar(c1,c2);
		return resta;
	}

	public abstract int comparar(Cheque c1, Cheque c2);

}
