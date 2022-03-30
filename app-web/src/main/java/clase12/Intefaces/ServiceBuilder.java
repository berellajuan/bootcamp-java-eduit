package clase12.Intefaces;

public class ServiceBuilder {
	public final static IService buildService(String site) {
		
		IService service;
		switch (site) {
		case "1":
			service = new ServiceS1();
			break;
		case "2":
			service = new ServiceS2();
			break;
		default:
			service = new DefaultService();
			break;
		}
		
		return service;
		
	}
	
}
