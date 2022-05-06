package ar.com.educacionit.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ar.com.educacionit.db.exceptions.GenericException;

//clase administradora de la conexion con SQL
public class AdministradorDeConexiones{
	//static para no tener que instanciarlo
	public static Connection obtenerConexion() throws GenericException{
		String host = "localhost";
		String user="root";
		String password="admin";
		String dbName = "bootcamp-java-educacionit";
		
		//Se asume el puerto por defecto 3306
		// URL SE Compone jdbc:motor://host:puerto/nombreBaseDatos/?..ConfigDriverJDBC
		String url = "jdbc:mysql://" + host + "/" + dbName + "?serverTimeZone=UTC&userSLL=false";
		
		// camino a la dependencia de mySQL para configurar el driver
		String driverName = "com.mysql.cj.jdbc.Driver";
		
		try {
			// Creo la la clase que pertenece la dependencia mysql-connector
			Class.forName(driverName);

			Connection connection = DriverManager.getConnection(url, user, password);

			return connection;

		} catch (SQLException sqle) {
			throw new GenericException("No se pudo conectar a: "+ url,sqle);

		} catch (ClassNotFoundException ncfe) {
			throw new GenericException("No se encontro el driver "+driverName,ncfe);
		}

	}
}
