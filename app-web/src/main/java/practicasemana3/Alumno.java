package practicasemana3;

import java.util.Iterator;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class Alumno {
	
	private String nombre;
	private String apellido;
	private Examen[] nroExamen;
	

	public Alumno(String nombre, String apellido, Examen[] nroExamen) {
		this.nombre = nombre;
		this.apellido = apellido;
		this.nroExamen = nroExamen;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public Examen[] getNroExamen() {
		return nroExamen;
	}

	public void setNroExamen(Examen[] nroExamen) {
		this.nroExamen = nroExamen;
	}
	
	public int notaMaxima() {

		int mayor = this.nroExamen[0].getNota();
		
		
		for (Examen examen : nroExamen) {
			if(mayor < examen.getNota()) {
				mayor = examen.getNota();
			}
		}
		
		return mayor;
		
	}
	
	public int notaBaja() {

		int menor = this.nroExamen[0].getNota();
		
			for (Examen examen : nroExamen) {
				if(menor > examen.getNota()) {
					menor = examen.getNota();
				}
			}
		
		return menor;
		
	}
	
	public float promedio() {
		int sumaNotas=0;
		for (int i =0; i < nroExamen.length; i++) {
			sumaNotas += nroExamen[i].getNota();
		}
		
		return sumaNotas/nroExamen.length;
	}
	



	

}
