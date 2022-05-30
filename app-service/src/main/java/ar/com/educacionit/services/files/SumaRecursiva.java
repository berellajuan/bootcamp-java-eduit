package ar.com.educacionit.services.files;

public class SumaRecursiva {

	public static void main(String[] args) {
		
		int valorSumado = suma(5);
		int factorial = factorial(5);
		System.out.println(valorSumado);
		
		System.out.println(factorial);
		System.out.println(esPalindromo("menem"));
		
	}
	// un caso base: donde termina la recursividad
	public static int suma(int n) {
		//Identificar el caso base
		if(n > 0) {
			return n + suma(n-1);
		}
		return n;
	}
	
	/* Calcular el factorial de un numero N */
	
	public static int factorial(int n) {
		if(n > 1) {
			return n * factorial(n-1);
		}
		return 1;
	}
	/*
	  MENEM
	  NEQUEN
	   
	 */
	public static boolean esPalindromo(String palabra) {
		if(palabra.length() <= 1) {
			return true;			
		}else {
			if(palabra.charAt(0) == palabra.charAt(palabra.length()-1)) {
				return esPalindromo(palabra.substring(1,palabra.length()-1));
			}else 
				return false;
			
		}
	}

}
