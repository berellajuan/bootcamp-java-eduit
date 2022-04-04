package practicasemana4;

/*
 Hola chicos, buenas noches.
Tal como les coment� en clases, les dejo el enunciado del ejercicio semanal.

Crear un branch con el nombre practica-adicional-semana4 
La idea es desarrollar un peque�o programa para incorporar los conceptos de clases, atributos, m�todos, clases abstractas, interfaces, 
composici�n, agregaci�n. -Existe una torre de control donde operadores pueden determinar ciertos voladores que pueden aterrizar 
en la pista de aterrizaje. Los voladores son, avi�n, helic�ptero, Superman, ovni. Los atributos que comparten 
son: nombre, (agregar otros de ser necesario) Cada volador tiene atributos particulares (decidir los que crean convenientes). 
Ej: avi�n puede tener cantidad de asientos, el helic�ptero puede tener color, marca, modelo etc. 
En la pista solo podr�n aterrizar aquellos voladores que cumplan con la interfaz Aterrizable. Escribir las clases e interfaces, 
adem�s de las relaciones de herencias necesarias para poder resolverlo. 
 */
public class TorreControlMain {
	public static void main(String[] args) {
		Volador[] voladores = voladores();
		
		for (Volador volador : voladores) {
			if(volador instanceof Aterrizable) {
				Aterrizable a = (Aterrizable)volador;
				a.aterrizar();
			}else {
				System.out.println(volador.getNombre() + "-> No puede Aterrizar en la pista");
			}
		}

	}

	public static Volador[] voladores() {
		Avion avion = new Avion("Boeing 747", 120);
		Helicoptero heli  = new Helicoptero("Apache", 10000F);
		Ovni ovni = new Ovni("Platillo Volador", 15);
		Superman superMan = new Superman("Kripton");
		
		return new Volador[] {avion,heli,ovni,superMan};
	}

}
