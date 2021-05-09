package DataStructures;

/**
 *Clase DoubleNode: Esta clase define el doble nodo que se va implemenar para
 * la lista Doblemente Enlazada.
 */

public class DoubleNode<Class> {
	private DoubleNode<Class> next;
	private DoubleNode<Class> prev;
	private Class value;
	
	public DoubleNode() {
		this.next = null;
		this.prev = null;
		this.value = null;
	}
/**
	 *Metodo getNext: retorna el siguiente valor al nodo.
*/
	public DoubleNode<Class> getNext() {
		return next;
	}
/**
	 *Metodo setNext: ingresa el valor anterior al nodo.
 */
	public void setNext(DoubleNode<Class> next) {
		this.next = next;
	}
/**
	 *Metodo getNext: retorna el valor anterior al nodo.
*/
	public DoubleNode<Class> getPrev() {
		return prev;
	}
/**
	 *Metodo setNext: ingresa el siguiente valor al nodo.
*/
	public void setPrev(DoubleNode<Class> prev) {
		this.prev = prev;
	}
/**
	 *Metodo get: retorna el valor del nodo.
 */
	public Class getValue() {
		return value;
	}
/**
	 *Metodo set: ingresa un valor al nodo.
*/
	public void setValue(Class value) {
		this.value = value;
	}
}
