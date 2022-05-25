package ar.com.educacionit.impl;

import java.lang.reflect.Field;
import java.util.Date;

import ar.com.educacionit.domain.Articulo;
import ar.com.educacionit.domain.Categorias;
import ar.com.educacionit.domain.Orden;


//DEMOSTRACION API REFRECTION
public class ReflectionApiMain {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException{
		Articulo art = new Articulo(1l,"titulo","codigo",new Date(),1500d, 1l,1l,1l);
		
		Categorias cat = new Categorias(1L, "desc 112",1L);
		
		Orden ord = new Orden(1l,"o2131",150F);
		
		System.out.println("--ARTICULO--");
		mostrarAtributos(art);
		System.out.println("--CATEGORIA--");
		mostrarAtributos(cat);
		System.out.println("--ORDEN--");
		mostrarAtributos(ord);
		
	}

	private static void mostrarAtributos(Object obj) throws InstantiationException, IllegalAccessException  {
		//Como se que atributos tiene ?
		//getDeclaredFields veo los atributos de un objeto instanciado tomando su clase
		Field[] arts = obj.getClass().getDeclaredFields();
		
		//Crear una instancia
		//Object newInstance = obj.getClass().getConstructors();
		
		for(Field f : arts) {
			
			
			//Como el atributo es privado con esto le digo que los voy a ver
			f.setAccessible(true);
			
			//forma de listar los nombres de los atributos
			System.out.print(f.getName());
			// muestra un numero que representa el valor del atributo 2 = Private
			//System.out.println(f.getModifiers());

			//tomo 1 atributo del objeto instanciado y le pido el Field de ese atributo
			//tomo clase de un objeto instanciado, y le digo que me de los atributos de ese objeto que instancie
			// F le paso un object y le digo que me mande un field de ese objeto
		
			Object valor = f.get(obj);
			System.out.println(" "+valor);
		}
	}
	

}
