package clase12.Intefaces;

public class ServiceMain {
	public static void main(String[] args) {
		String sitio="2";
		
		//creo mi servicio en base al site
		IService service = ServiceBuilder.buildService(sitio);
		//ctr+t para ver services
		Dato dato = service.consultar();
		
		
		dato.detalle();
		
		Formateable f= new FormatoPDF(dato);
		
		f.formatear();
	}
}
