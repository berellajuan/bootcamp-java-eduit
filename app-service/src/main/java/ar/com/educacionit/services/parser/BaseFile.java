package ar.com.educacionit.services.parser;

import java.io.File;

import ar.com.educacionit.services.exceptions.ParseException;

public abstract class BaseFile {
	
	protected String filePath;
	//path
	public BaseFile(String filePath) {
		if(filePath == null || "".equals(filePath)) {
			//lanzo exception
			throw new IllegalArgumentException("Debe indicar el path del archivo");
		}
		this.filePath = filePath;
	}
	
	protected File getFile() throws ParseException {
		File file = new File(this.getFilePath());
		
		if(file.exists()) {
			throw new ParseException("no existe el archivo "+file.getAbsolutePath());
		}
		return file;
	}
	
	private String getFilePath() {
		return filePath;
	}

}
