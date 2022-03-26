package clase10;

import clase7.Articulo;

public class Musica extends Articulo{
	private String[] listaTemas;
	
	public Musica(Long id, String nombre, String autor, Double precio, String urlImagen,String [] temas) {
		super(id, nombre, autor, precio, urlImagen);
		listaTemas = temas;
	}

	public String[] getListaTemas() {
		
		return this.listaTemas != null ? this.listaTemas : new String[0];

	}

	public void setListaTemas(String[] listaTemas) {
		this.listaTemas = listaTemas;
	}
	
	public void agregarTema(String tema) {
		String listaActualizada[] = new String[this.listaTemas.length+1];
		for (int i = 0; i < listaActualizada.length; i++) {
			if(this.listaTemas.length-1 >= i ) {
				listaActualizada[i] = this.listaTemas[i];
			}else{
				listaActualizada[i] = tema;
			}	
		}
		this.listaTemas = listaActualizada;
			
	}
	/*
	@Override
	public void detalle() {
		super.detalle();
		System.out.println("Lista de temas");
		for(String tema: this.getListaTemas()) {
			System.out.println(tema);
		}
	}
	 */
	@Override
	public void detalleHijo() {
		System.out.println("Lista de temas");
		for(String tema: this.getListaTemas()) {
			System.out.println(tema);
		}
		
	}
	

}
