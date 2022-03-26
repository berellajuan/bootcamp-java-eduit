package clase10;

import clase7.Articulo;

public class Libro extends Articulo{
	
	private String isbn;

	public Libro() {
		super(null, null, null, null, null);
	}

	public Libro(Long id, String nombre, String autor, Double precio, String urlImagen, String isbn) {
		super(id, nombre, autor, precio, urlImagen);
		this.isbn = isbn;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	/*
	@Override
	public void detalle() {
		super.detalle();
		System.out.println("ISBN " + this.isbn);
		
	}
	*/
	//libro esta obligado a implementar detalle hijo de la clase padre
	@Override
	public void detalleHijo() {
		System.out.println("ISBN " + this.isbn);
		
	}

}
