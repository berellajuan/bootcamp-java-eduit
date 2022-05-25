package ar.com.educacionit.services.files;

import java.io.File;
import java.io.IOException;

public class FirstFileMain {
	public static void main(String[] args) throws IOException {
		File archivo = new File("f:/test.txt");
		
		boolean existe = archivo.exists();
		
		if(!existe) {
			archivo.createNewFile();
		}
		
		existe = archivo.exists();
		System.out.println(existe);
		
	}
	
}
