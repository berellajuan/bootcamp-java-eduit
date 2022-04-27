package clase19practicasemanal;

import clase7.Articulo;

public class AccionAlta implements IAccion {

	@Override
	public void exec(Articulo ctx) {

		//usa la base de datos en memoria
		InMemoryDB.save(ctx.getId(), ctx);
	}

}
