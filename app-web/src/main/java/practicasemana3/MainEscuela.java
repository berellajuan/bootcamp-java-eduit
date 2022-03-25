package practicasemana3;

import java.util.Scanner;
/*
Hola chicos, buenas noches.
Tal como les comenté en clases, les dejo el enunciado del ejercicio semanal.

Crear un branch con el nombre practica-adicional-semana3:
                 La idea es practicar ciclos, dobles con vectores, máximo, mínimo, promedio.
                 realizar el siguiente ejercicios:
                 La escuela primaria xyz solicita el desarrollo de una aplicación para poder llevar el control de notas para cada alumno.
                 El programa solicitará el ingreso la cantidad de alumnos a procesar.
                 Para cada alumno se deberá ingresar los siguientes datos:
                 - nombre (string)
                 - apellido (string)
                 - número de examen
                 - nota que obtuvo el alumno (numérico >=0 <=10)
                 Al finalizar la carga de datos, se procederá a listar la siguiente información:
                 
                 ok 1- alumno/s con la calificación mas alta
                 ok 2- alumno/s con la calificación mas baja
                 ok 3- alumnos que promocionan, aquellos que obtuvieron un promedio >= 7
                 ok 4- alumnos que deben recursar la materia, aquellos que obtuvieron un promedio < 7"

Saludos,
*/
public class MainEscuela {

	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		Integer cant;
		
		do {
			System.out.print("Ingrese la cantidad de alumnos a ingresar: ");
			cant = teclado.nextInt();
		}while(cant < 0);
		teclado.nextLine();
		
		Alumno[] alumnos = new Alumno[cant];
		String nombre;
		String apellido;
		Integer examenes;
		Integer nota;
		
		do {
			for (int i = 0; i < cant; i++) {
				
				System.out.print("Ingrese el nombre nro["+(i+1)+"]: ");
				nombre=teclado.nextLine();
				
				System.out.print("Ingrese apellido nro["+(i+1)+"]: ");
				apellido=teclado.nextLine();
				
				
				do {
					System.out.print("Ingrese la cantidad de  examenes para el alumno " + nombre + " " + apellido + ": ");
					examenes=Integer.parseInt(teclado.nextLine());
				}while(examenes < 0);
				
				Examen[] nroExam = new Examen[examenes];
						
				for( int j = 0; j < examenes; j++) {					
					do {
						System.out.print("Ingrese la nota para el examen nro["+(j+1)+"]: ");
						nota=Integer.parseInt(teclado.nextLine());
					}while(nota < 0 || nota > 10);
					
					nroExam[j]=new Examen(nota);
					
				}	
				
				alumnos[i] = new Alumno(nombre,apellido,nroExam);
				
				System.out.println("Alumno "+ (i+1) +" Cargado con Exito!");
			}
		}while(alumnos.length != cant);
		
		teclado.close();
		
		
		EscuelaPrimaria escuela = new EscuelaPrimaria(alumnos);
		System.out.println("*************************************");
		System.out.println("Informacion de las notas y alumnos");
		System.out.println("------------\n");
		escuela.notasMaximas();
		System.out.println("-----------\n");
		escuela.notasMinimas();
		System.out.println("-----------\n");
		escuela.alumnosPromocionados();
		System.out.println("-----------\n");
		escuela.alumnosNoPromocionados();
		
		
	}


}
