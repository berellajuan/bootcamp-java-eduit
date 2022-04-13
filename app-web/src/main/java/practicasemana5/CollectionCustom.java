package practicasemana5;

import java.util.Arrays;

/*
 	Debido a que tenemos dos dias menos  el ejercicio se entrega el lunes 18/4.

	Buen d�a chicos.

	Les dejo el ejercicio semanal.

	Crear un clase CollectionCustom<T>
	La clase tiene un atributo T[] �un array de T� en el cual se deben guardar los tipos una vez creada la implementaci�n.

	- debe tener los m�todos
	size():int
	addFirst(T): void
	addLast(T):void
	add(T):void
	remove(T): T remueve el primer elemento indicado y lo retorna
	removeAll(T): void remueve todos los elementos.
	boolean empty(): indica si la colecci�n est� vac�a

	Crear la clase Main para probar cada m�todo.
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

	// add(T) Seria lo mismo que addLast?
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
					this.vector[i] = null;
					break;
				}
			}
		}
		return res;
	}

	public void removeAll() {
		Object[] aux = new Object[0];
		this.vector = (T[]) aux;
	}

	public int size() {
		int res;
		if (this.vector == null) {
			res = 0;
		} else {
			res = this.vector.length;
		}

		return res;
	}

	public boolean empty() {
		return this.size() == 0;
	}

	@Override
	public String toString() {
		return Arrays.toString(vector);
	}

}
