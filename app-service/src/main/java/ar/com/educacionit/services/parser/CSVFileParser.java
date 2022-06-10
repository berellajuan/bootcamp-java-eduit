package ar.com.educacionit.services.parser;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

import ar.com.educacionit.services.exceptions.ParseException;

public class CSVFileParser implements IParser<Collection<Producto>>{
	
	private String filePath;
	//path
	public CSVFileParser(String filePath) {
		if(filePath == null || "".equals(filePath)) {
			//lanzo exception
			throw new IllegalArgumentException("Debe indicar el path del archivo");
		}
		this.filePath = filePath;
	}
	
	@Override
	public Collection<Producto> parse() throws ParseException {
		File file = getFile();
		
		try {
			return leerArchivo(file);
		} catch (IOException e) {
			e.printStackTrace();
			throw new ParseException("Error leyendo el archivo: " +file.getName(),e);
		}		
	}

	protected File getFile() throws ParseException {
		File file = new File(this.getFilePath());
		
		if(file.exists()) {
			throw new ParseException("no existe el archivo "+file.getAbsolutePath());
		}
		return file;
	}
	
	private static Collection<Producto> leerArchivo(File file) throws IOException {

		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		//Comienzo de lectura por linea
		String linea = null;
		//br.readLine() lee la linea hasta un salto de linea
		linea = br.readLine();
		Collection<Producto> sociosList = new ArrayList<>();
		
		while((linea = br.readLine()) != null) {
			Producto socio = rowFromString(linea);
			sociosList.add(socio);
		}
		br.close();
		
		return sociosList;
	}
	/* TDD + DDD*/
	private static Producto rowFromString(String linea) {
		String[] array = linea.split(";");
		String id = array[0];
		String titulo = array[1];
		String codigo = array[2];
		String precio = array[3];
		
		return new Producto(Long.parseLong(id),titulo,codigo,Double.parseDouble(precio));
		
	}

	private String getFilePath() {
		return filePath;
	}
	
	

}
