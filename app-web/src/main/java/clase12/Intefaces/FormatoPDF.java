package clase12.Intefaces;

public class FormatoPDF extends FormatoBase implements Formateable {

	public FormatoPDF(Dato dato) {
		super(dato);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void formatear() {
		System.out.println("Formatenadoe en pdf");

	}

}
