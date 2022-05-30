package ar.com.educacionit.services.files;

import java.io.File;
import java.io.IOException;

public class FirstFileMain2 {
	public static void main(String[] args) throws IOException {
		File archivo = new File("f:/");
		

		boolean isFile = archivo.isFile();
		boolean isDirectory = archivo.isDirectory();
		
		System.out.println(isFile);
		System.out.println(isDirectory);	
		
		//recursividad capacidad de una funcion o metodo de llamarse a si mismo

	}
	

}
