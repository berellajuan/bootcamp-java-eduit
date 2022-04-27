package clase19practicasemanal;

import clase19practicasemanal.exceptions.MemoryDBCRUDException;
import clase7.Articulo;

public interface IAccion{

	public void exec(Articulo ctx) throws MemoryDBCRUDException;
}
