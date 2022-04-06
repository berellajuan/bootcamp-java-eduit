package clase15.generic;

public interface IGenericOperation<T> {
	public T crear();
	public void eliminar();
	public T buscarPorId(Long id);
}
