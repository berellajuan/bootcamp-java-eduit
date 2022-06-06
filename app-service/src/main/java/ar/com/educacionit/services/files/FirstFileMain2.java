package ar.com.educacionit.services.files;

import java.io.File;
import java.io.IOException;

public class FirstFileMain2 {
	public static void main(String[] args) throws IOException {
		
		File archivo = new File("f:/vacia");
		
		
		String fileName = "hola.txt";
		
		boolean isFile = archivo.isFile();
		boolean isDirectory = archivo.isDirectory();
		
		System.out.println(isFile);
		System.out.println(isDirectory);	
		
		/*if(isDirectory) {
			String[] filesNames = archivo.list();
			for(String name : filesNames) {
				System.out.println(name);
			}
		}else {
			System.out.println(archivo.getName());
		}
		*/
		File busqueda = buscarFile(archivo,fileName);
		System.out.println(busqueda);
		
		//recursividad capacidad de una funcion o metodo de llamarse a si mismo
		
		

	}
	public static File buscarFile(File file,String filename) {
		File aux = null;
		
		if(!file.isDirectory()) {
			if(file.getName().equalsIgnoreCase(filename)){
				System.out.println(file.getName().charAt(0));
				System.out.println(filename.charAt(0));
				if(file.getName().charAt(0) != filename.charAt(0)) {
					return null;
				}else {
					return file;
				}
			}
		}else {
			File[] filesInFile = file.listFiles();
			for (File file2 : filesInFile) {
				aux = buscarFile(file2,filename);
				if(aux != null) {
					break;
				}
			}					
		}
		
		return aux;
	}
	

}
