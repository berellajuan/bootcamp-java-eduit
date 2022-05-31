package ar.com.educacionit.services.files;

public class Arbol {
	private boolean root;
	private Nodo nodo;
	
	public Arbol(boolean root, Nodo nodo) {
		this.root = root;
		this.nodo = nodo;
	}

	public boolean getRoot() {
		return root;
	}

	public void setRoot(boolean root) {
		this.root = root;
	}

	public Nodo getNodo() {
		return nodo;
	}

	public void setNodo(Nodo nodo) {
		this.nodo = nodo;
	}
	
	

	
	
	
	
}
