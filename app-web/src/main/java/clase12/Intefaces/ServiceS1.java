package clase12.Intefaces;

public class ServiceS1 implements IService{

	@Override
	public Dato consultar() {
		//Suponer una consulta de URL y retorna id=1|nombre=jose|sueldo=1400
		
		String response = "{id=1,nombre=jose,sueldo=1400}";
		
		//parse
		
		String[] spliited = response.split(",");
		
		Long id = null;
		String descripcion = null;
		//validar data
		if(spliited.length > 2){
			//id
			String idString = parseString(spliited[0],"=",1);
			
			//nombre
			String nombre = parseString(spliited[1], "=", 1);
			
			if(idString != null) {
				id = Long.parseLong(idString);
			}
			
			if(nombre != null) {
				descripcion = nombre;
			}
		}
		
		return new Dato(id,descripcion);
		
	}
	
	public String parseString(String springParse,String deli,int idx) {
		return springParse.split(deli)[idx]; //ctrl+shift+i
	}

}
