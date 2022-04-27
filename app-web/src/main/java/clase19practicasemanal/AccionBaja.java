package clase19practicasemanal;

import clase19practicasemanal.exceptions.MemoryDBCRUDException;
import clase7.Articulo;

public class AccionBaja implements IAccion {
	
	@Override
	public void exec(Articulo ctx) throws MemoryDBCRUDException{
		
		//dar de baja por id
		InMemoryDB.delete(ctx.getId());
		
		System.out.println("Se ha elminado el articulo de id:" + ctx.getId());
	}

}
