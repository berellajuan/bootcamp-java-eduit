package clase19practicasemanal;

import clase7.Articulo;

public class AccionModificacion implements IAccion {

	@Override
	public void exec(Articulo ctx) throws MemoryDBException {
		
		Articulo art = InMemoryDB.getById(ctx.getId());
		
		//System.out.println("Ingrese titulo nuevo");
		
		if(art != null) {
			InMemoryDB.update(ctx.getId(), ctx);
		}
	}

}
