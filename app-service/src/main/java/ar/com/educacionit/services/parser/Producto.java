package ar.com.educacionit.services.parser;

public class Producto {

	private Long id;
	private String titulo;
	private String codigo;
	private Double precio;

	public Producto(Long id, String titulo, String codigo, Double precio) {
		this.id = id;
		this.titulo = titulo;
		this.codigo = codigo;
		this.precio = precio;
	}

	public Producto() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", titulo=" + titulo + ", codigo=" + codigo + ", precio=" + precio + "]";
	}
	
	

}
