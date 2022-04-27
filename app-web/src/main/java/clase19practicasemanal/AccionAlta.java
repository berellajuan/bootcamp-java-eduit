package clase19practicasemanal;

import clase19practicasemanal.exceptions.MemoryDBCRUDException;
import clase7.Articulo;

public class AccionAlta implements IAccion {

	@Override
	public void exec(Articulo ctx) throws MemoryDBCRUDException{

		//usa la base de datos en memoria
		InMemoryDB.save(ctx.getId(), ctx);
	}

}
