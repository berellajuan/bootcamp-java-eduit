package practicasemana2;

import java.util.Scanner;

/*
 Ingresar una fecha por teclado  dd/mm/yyyy (dd int, mm int, yyyy int)
 validar que dd >=1 && <=31 TENIENDO EN CUENTA EL MES
 validar que mes >=1 && <=12
 validar que a�o >=1900 && <= 2099
 Ojo, si el a�o es bisiesto febrero tiene 29  d�as.
 Informar por consola  si la fecha es correcta.
 */
public class ValidacionFechas {
	public static void main(String[] args) {
		Scanner teclado = new Scanner(System.in);
		System.out.print("Ingrese Dia: ");
		int dia = teclado.nextInt();
		System.out.print("Ingrese Mes: ");
		int mes = teclado.nextInt();
		System.out.print("Ingrese A�o: ");
		int anio = teclado.nextInt();
		if(validarFecha(dia, mes, anio)) {
			System.out.println("La fecha: " + dia +"/"+ mes + "/" + anio +" Es CORRECTA");
		}else {
			System.out.println("La fecha: " + dia +"/"+ mes + "/" + anio +" Es INCORRECTA");
		}
		
		teclado.close();
		
		
	}
	
	public static boolean validarFecha(int dia,int mes, int anio) {
		boolean res=false;
		if(dia > 0 && anio >= 1900 && anio <= 2099 && mes >= 1 && mes <= 12) {
			
			switch (mes) {
			case 1:
				if(dia <=31) {
					res = true;
				}
				break;
			case 2:
				if(!esBiciesto(anio) && dia >= 29) {
					res=false;
				}else if(dia <= 29){
					res=true;
				}
				break;
			case 3:
				if(dia <=31) {
					res=true;
				}
				break;
			case 4:
				if(dia <= 30) {
					res = true;
				}
				break;
			case 5:
				if(dia <= 31) {
					res = true;
				}
				break;
			case 6:
				if(dia <= 30) {
					res = true;
				}
				break;
			case 7:
				if(dia <= 31) {
					res = true;
				}
				break;
			case 8:
				if(dia <= 31) {
					res = true;
				}
				break;
			case 9:
				if(dia <= 30) {
					res = true;
				}
				break;
			case 10:
				if(dia <= 31) {
					res = true;
				}
				break;
			case 11:
				if(dia <= 30) {
					res = true;
				}
				break;
			case 12:
				if(dia <= 31) {
					res = true;
				}
				break;
			
			}
		}
		
		return res;
	}
	
	//Valida si es Biciesto
	public static boolean esBiciesto(int anio) {
		return anio % 4 == 0 && anio % 100 != 0|| anio % 400 == 0;
	}
	
}


