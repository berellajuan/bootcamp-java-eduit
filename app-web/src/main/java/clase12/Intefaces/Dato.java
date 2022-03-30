package clase12.Intefaces;

public class Dato {
	private Long id;
	private String descripcion;
	
	public Dato(Long id, String descripcion) {
		this.id = id;
		setDescripcion(descripcion);
	}
	
	public void detalle() {
		System.out.println("id: " + this.id);
		System.out.println("Descripcion: " + this.descripcion);
	}

	public Long getId() {
		return id;
	}

	public String getDescripcion() {
		return descripcion;
	}
	
	private void setDescripcion(String desc) {
		if(desc != null) {
			this.descripcion = desc.trim();
		}
	}
	
	
}
