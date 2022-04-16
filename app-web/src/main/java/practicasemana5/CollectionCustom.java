package practicasemana5;

import java.util.Arrays;

/*
 	Debido a que tenemos dos dias menos  el ejercicio se entrega el lunes 18/4.

	Buen día chicos.

	Les dejo el ejercicio semanal.

	Crear un clase CollectionCustom<T>
	La clase tiene un atributo T[] “un array de T” en el cual se deben guardar los tipos una vez creada la implementación.

	- debe tener los métodos
	size():int
	addFirst(T): void
	addLast(T):void
	add(T):void
	remove(T): T remueve el primer elemento indicado y lo retorna
	removeAll(T): void remueve todos los elementos.
	boolean empty(): indica si la colección está vacía

	Crear la clase Main para probar cada método.
	No usar collection vistas en clase, deben trabajar con array de T, uds deben implementar la logica.

	Saludos
 */
public class CollectionCustom<T> {
	private T[] vector;

	public CollectionCustom(T[] vector) {
		this.vector = vector;
	}

	public void addFrist(T o) {
		if (o != null) {
			Object[] aux = new Object[vector.length + 1];
			if (this.empty()) {
				aux[0] = o;
				this.vector = (T[]) aux;
			} else {
				for (int i = 0; i < this.size(); i++) {
					if (i == 0) {
						aux[0] = o;
					}
					aux[i + 1] = this.vector[i];
				}
				this.vector = (T[]) aux;
			}
		}
	}

	public void addLast(T o) {
		if (o != null) {
			Object[] aux = new Object[vector.length + 1];
			if (this.empty()) {
				aux[0] = o;
				this.vector = (T[]) aux;
			} else {
				for (int i = 0; i < this.size(); i++) {
					aux[i] = this.vector[i];
				}
				aux[this.size()] = o;
				this.vector = (T[]) aux;
			}
		}
	}

	public void add(T o) {
		if (o != null) {
			Object[] aux = new Object[vector.length + 1];
			if (this.empty()) {
				aux[0] = o;
				this.vector = (T[]) aux;
			} else {
				for (int i = 0; i < this.size(); i++) {
					aux[i] = this.vector[i];
				}
				aux[this.size()] = o;
				this.vector = (T[]) aux;
			}
		}
	}

	public T remove(T o) {
		T res = null;

		if (!this.empty() && o != null) {
			for (int i = 0; i < this.size(); i++) {
				if (this.vector[i].equals(o)) {
					res = this.vector[i];
					this.moveLeft(i);
					break;
				}
			}
			this.resizeMin();
		}

		return res;
	}

	// metodo para achicar el vector
	private void resizeMin() {
		Object[] aux = new Object[vector.length - 1];
		for (int j = 0; j < this.size() - 1; j++) {
			aux[j] = this.vector[j];
		}
		this.vector = (T[]) aux;
	}

	// metodo para mover los elementos a la izq
	private void moveLeft(int pos) {
		for (int i = pos; i < this.size() - 1; i++) {
			this.vector[i] = this.vector[i + 1];
		}
	}

	public void removeAll() {
		Object[] aux = new Object[0];
		this.vector = (T[]) aux;
	}

	public int size() {
		return this.vector == null ? 0 : this.vector.length;
	}

	public boolean empty() {
		return this.size() == 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(vector);
	}



}
