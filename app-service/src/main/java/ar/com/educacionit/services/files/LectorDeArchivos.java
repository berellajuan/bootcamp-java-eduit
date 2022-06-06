package ar.com.educacionit.services.files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import ar.com.educacionit.domain.Socios;
import ar.com.educacionit.services.SociosService;
import ar.com.educacionit.services.exceptions.ServiceException;
import ar.com.educacionit.services.impl.SociosServiceImpl;

public class LectorDeArchivos {
	public static void main(String[] args) throws IOException {
		String path = "F:/vacia/saludo/hola.txt";
		File file = new File(path);
		
		if(file.exists()) {
			List<Socios> socios = leerArchivo(file);
			if(!socios.isEmpty()) {
				SociosService ss = new SociosServiceImpl();
				for(Socios s: socios) {
					try {
						ss.create(s);
					}catch(ServiceException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	private static List<Socios> leerArchivo(File file) throws IOException {

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		//Comienzo de lectura por linea
		String linea = null;
		//br.readLine() lee la linea hasta un salto de linea
		linea = br.readLine();
		List<Socios> sociosList = new ArrayList<>();
		
		while((linea = br.readLine()) != null) {
			Socios socio = sociosFromString(linea);
			sociosList.add(socio);
		}
		br.close();
		
		return sociosList;
	}

	private static Socios sociosFromString(String linea) {
		String[] array = linea.split(";");
		String apellido = array[0];
		String nombre = array[1];
		String codigo = array[2];
		
		return new Socios(apellido,nombre,codigo);
		
	}
	
}
