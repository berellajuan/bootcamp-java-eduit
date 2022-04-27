package clase19practicasemanal;

import java.util.Scanner;

import clase10.Libro;
import clase19practicasemanal.exceptions.MemoryDBCRUDException;
import clase7.Articulo;

public class MainMap {

	/*
	Hola chicos, buenas noches.
	Tal como les comenté en clases, les dejo el enunciado del ejercicio semanal.
	Crear un branch con el nombre practica-adicional-semana6
	- Tomar como base la clase19, donde creamos una clase InMemoryDB
	- crear una exception por cada operación que realiza la base de datos.
	- modificar la interface IAction para poder lanzar dichas exceptions
	- modificar la clase MainMap para controlar e informar los errores.
	*/
	public static void main(String[] args) {
	
		Integer opcionIngresadaPorUsuario = 1;
		
		// Interface i = new ClaseQueImplementaLaInterface();		
		IAccion accion = AccionMap.getAccion(opcionIngresadaPorUsuario);//AltaAccion|BajaAccion|AccionDefault
		
		//Comento esta parte para poder probar los Exceptions
		//Articulo articulo = contruirArticulo();
		Articulo articulo = new Libro(5L,"Batman","DC COMIDS",1500D,"URL/IMG","15steg");
		Articulo articulo2 = new Libro(5L,"Superman","DC COMIDS",10D,"URL/IMG","15steg");
		

		
		//ejecuto
		try {
			
			//InMemoryDB.save(1L, null);
			InMemoryDB.listAll();
			
			InMemoryDB.save(1L, articulo);
			
			InMemoryDB.listAll();
			
			//InMemoryDB.getById(null);
			System.out.println("Prueba de valor devuelto: " + InMemoryDB.getById(1L));
			
			//InMemoryDB.update(null, articulo);
			
			InMemoryDB.update(1L, articulo2);
			
			InMemoryDB.listAll();
			
			//InMemoryDB.delete(null);
			
			InMemoryDB.delete(1L);
			
			InMemoryDB.listAll();		
			
			
		} catch (MemoryDBCRUDException e) {
			e.printStackTrace();
		}
	
		
	}

	private static Articulo contruirArticulo() {
		Scanner teclado = new Scanner(System.in);
		Articulo art = new Libro();
		System.out.println("Ingrese titulo ");
		art.setAutor(teclado.next());
		System.out.println("Ingrese id ");
		art.setId(teclado.nextLong());
		
		//downcating
		System.out.println("Ingrese isbn");
		((Libro)art).setIsbn(teclado.next());
		//completar los demas datos
		teclado.close();
		
		
		return art;
	}
}
