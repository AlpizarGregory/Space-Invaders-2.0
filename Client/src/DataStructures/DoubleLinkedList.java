package DataStructures;
/**
 *Clase DoubleLinkedList: Esta clase es una lista doblemente enlazada, que es lo que se requiere
 *  para cear las clases "ClassB" y "ClassE"
 */

public class DoubleLinkedList<Class> implements List<Class> {
	private DoubleNode<Class> head;
	private int size;
	
	public DoubleLinkedList() {
		head = null;
		size = 0;
	}
/**
	 *Metodo add: agrega un valor a la lista.
**/
	@Override
	public void add(Class value) {
		DoubleNode<Class> newNode = new DoubleNode<Class>();
		newNode.setValue(value);
		if(head == null) {
			head = newNode;
			size++;
			return;
		}
		DoubleNode<Class> current = head;
		while(current.getNext() != null) {
			current = current.getNext();
		}
		newNode.setPrev(current);
		current.setNext(newNode);
		size++;
	}
/**
	 *Metodo remove: remueve un valor de la lista.
**/
	@Override
	public void remove(int index) {
		if(index == 0 && index < size) {
			head = head.getNext();
			size--;
			return;
		}
		DoubleNode<Class> current = head;
		int counter = 0;
		while(counter < index-1 && current.getNext() != null) {
			current = current.getNext();
			counter++;
		}
		if(counter == size-2) {
			current.setNext(null);
			size--;
			return;
		} else {
			current.setNext(current.getNext().getNext());
			size--;
			return;
		}
	}

/**
	 *Metodo get: retorna un valor de la lista.
*/
	@Override
	public Class get(int index) {
		if(index > size-1)
			return null;
		DoubleNode<Class> current = head;
		for(int c = 0; c < index; c++) {
			current = current.getNext();
		}
		return current.getValue();
	}
/**
 *	Vacía la lista
**/
	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}
/**
	 *Metodo size: retorna el tamaño de la lista.
 * */
	@Override
	public int size() {
		return size;
	}
/**
	 *Metodo swap: intercambia los nodos de las listas.
 **/
	@Override
	public void swap(int index1, int index2) {
		Class d1 = this.get(index1);
		Class d2 = this.get(index2);
		DoubleNode<Class> current = head;
		for(int c = 0; c < size; c++) {
			if(this.get(c) == d1) {
				current.setValue(d2);
			} else if(this.get(c) == d2) {
				current.setValue(d1);
			}
			current = current.getNext();
		}
	}
}
