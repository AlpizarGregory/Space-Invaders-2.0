package DataStructures;

/**
 *Clase Node: Esta clase define el node que se va implemenar para las listas enlazadas simple y circular.
 */
public class Node <Class> {
	private Class value;
	private Node<Class> next;
	
	public Node() {
		value = null;
		next = null;
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
/**
	 *Metodo getNext: retorna el siguiente valor al nodo.
*/
	public Node<Class> getNext() {
		return next;
	}
/**
	 *Metodo setNext: ingresa el siguiente valor al nodo.
*/
	public void setNext(Node<Class> next) {
		this.next = next;
	}
}