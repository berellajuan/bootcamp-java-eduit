package clase14;

import java.util.Iterator;

import javax.imageio.metadata.IIOMetadataFormatImpl;

public class Persona {
	private String nombre;
	private IIDioma idiomanativo;
	private IIDioma[] masIdiomas;

	public Persona(String nombre, IIDioma idiomanativo) {
		this.nombre = nombre;
		this.idiomanativo = idiomanativo;
		this.masIdiomas = new IIDioma[] {};
	}

	public void aprenderIdioma(IIDioma nuevoIdioma) {

		if (!existeIdioma(nuevoIdioma)) {
			this.agregarIdioma(nuevoIdioma);
		}

	}

	private void agregarIdioma(IIDioma nuevoIdioma) {
		IIDioma[] nuevosIdiomas = new IIDioma[this.masIdiomas.length + 1];

		for (int i = 0; i < this.masIdiomas.length; i++) {
			nuevosIdiomas[i] = this.masIdiomas[i];
		}
		nuevosIdiomas[nuevosIdiomas.length]=nuevoIdioma;
		this.masIdiomas=nuevosIdiomas;
	}

	public boolean existeIdioma(IIDioma idioma) {
		boolean existe = false;
		for(int i = 0 ; !existe && i < masIdiomas.length; i++) {
			existe = masIdiomas[i].getClass().equals(idioma.getClass());
		}
		return existe;
	}

	public void decir(String hablar) {
		if (hablar != null) {
			this.idiomanativo.decir(hablar);
		}
	}

	public void decir(String decir, IIDioma idioma) {
		IIDioma aux = null;
		if(!esMismoIdioma(this.idiomanativo, idioma)) {
			for (int i = 0; aux == null && i < this.masIdiomas.length; i++) {
				if (esMismoIdioma(this.masIdiomas[i], idioma)) {
					aux = idioma;
				}
			}
		}else {
			aux = this.idiomanativo;
		}
		
		if (aux != null) {
			idioma.decir(decir);
		} else {
			System.out.println(this.nombre + " no habla " + idioma.getClass().getCanonicalName());
		}

	}

	private boolean esMismoIdioma(IIDioma source, IIDioma target) {
		return source.getClass().equals(target.getClass());
	}
	
	public void decirEnTodos(String algo) {
		this.decir(algo);
		
		if(algo != null) {
			for (IIDioma idioma : masIdiomas) {
				idioma.decir(algo);
			}
		}
	}

}
