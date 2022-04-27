package ar.com.educacionit.db;

import ar.com.educacionit.db.exceptions.ConnectionException;

public class ConexionDB implements AutoCloseable{

	private boolean open;
	
	public ConexionDB(String username, String password) {
		System.out.println("Conectando a la db");
		//this.open = true;
	}
		
	public ConexionDB open() throws ConnectionException{
		if(!isOpen()) {
			this.open = true;
			return this;
		}else {
			throw new ConnectionException("La conexion ya esta abierta");
		}
	}
	
	public boolean isOpen() {
		return this.open;
	}
	
	public void close() {
		System.out.println("Ejecuto auto Closeable");
		if(this.isOpen()) {
			this.open = false;
		}
	}
	
	public void connect() {
		if(!isOpen()) {
			this.open = true;
		}else {
			System.err.println("ya conectado...");
		}
	}
}
