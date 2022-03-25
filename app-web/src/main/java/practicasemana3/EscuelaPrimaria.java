package practicasemana3;

public class EscuelaPrimaria {
	private Alumno[] alumnos;

	public EscuelaPrimaria(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	public Alumno[] getAlumnos() {
		return alumnos;
	}

	public void setAlumnos(Alumno[] alumnos) {
		this.alumnos = alumnos;
	}

	public void notasMaximas() {

		// Mayor nota de cada Alumno
		int mayor = alumnos[0].notaMaxima();
		for (Alumno alumno : alumnos) {
			if (mayor < alumno.notaMaxima()) {
				mayor = alumno.notaMaxima();
			}
		}

		// Mostrar las notas maximas de la escuela
		System.out.println("Alumos con calificaciones mas altas, que es " + mayor + " son: ");
		for (Alumno alumno : alumnos) {
			if (mayor == alumno.notaMaxima()) {
				System.out.println("Nombre: " + alumno.getNombre() + " Apellido: " + alumno.getApellido());
			}
		}
	}

	public void notasMinimas() {

		// Mayor nota de cada Alumno
		int minima = alumnos[0].notaBaja();
		for (Alumno alumno : alumnos) {
			if (minima > alumno.notaBaja()) {
				minima = alumno.notaBaja();
			}
		}

		// Mostrar las notas bajas de la escuela
		System.out.println("Alumos con calificaciones mas bajas, que es " + minima + " son: ");
		for (Alumno alumno : alumnos) {
			if (minima == alumno.notaBaja()) {
				System.out.println(alumno.getNombre() + " Apellido: " + alumno.getApellido());
			}
		}
	}
	
	public void alumnosPromocionados() {
		System.out.println("Alumnos promocionados: ");
		for (Alumno alumno : alumnos) {
			if(alumno.promedio() >= 7) {
				System.out.println("Nombre: "+alumno.getNombre() + " Apellido: " + alumno.getApellido() + " con un promedio de : " + alumno.promedio());
			}
		}
	}
	
	public void alumnosNoPromocionados() {
		System.out.println("Alumnos no promocionados: ");
		for (Alumno alumno : alumnos) {
			if(alumno.promedio() < 7) {
				System.out.println(alumno.getNombre() + " Apellido: " + alumno.getApellido() + " con un promedio de : " + alumno.promedio());
			}
		}
	}
}
