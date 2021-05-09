package DataStructures;

/**
 *Clase SimplyLinkedList: Esta clase define una lista enlazada que es la que se usa para implementar
 * la clase "Basic" y la clase "ClassA", de las hileras enemigas
 */
public class SimplyLinkedList<Class> implements List<Class> {
	private Node<Class> head;
	private int size;

	public SimplyLinkedList() {
		head = null;
		size = 0;
	}

/**
 	*Metodo add: agrega un valor a la lista.
 */
	@Override
	public void add(Class value) {
		Node<Class> newNode = new Node<Class>();
		newNode.setValue(value);
		if(head == null) {
			head = newNode;
			size++;
		} else {
			Node<Class> current = head;
			while(current.getNext() != null) {
				current = current.getNext();
			}
			current.setNext(newNode);
			size++;
		}
	}
/**
	 *Metodo remove: remueve un valor de la lista.
 */
	
	@Override
	public void remove(int index) {
		if(index == 0 && index < size) {
			head = head.getNext();
			size--;
			return;
		}
		Node<Class> current = head;
		int counter = 0;
		while(counter < index-1 && current.getNext() != null) {
			current = current.getNext();
			counter++;
		}
		if(counter == size-2) {
			current.setNext(null);
			size--;

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
		Node<Class> current = head;
		for(int i = 0; i < index; i++) {
			current = current.getNext();
		}
		return current.getValue();
	}
/**
	 *Metodo size: retorna el tamaño de la lista.
**/
	@Override
	public int size() {
		return size;
	}
/**
 *  Vacía la lista
**/
	@Override
	public void clear() {
		this.head = null;
		this.size = 0;
	}
/**
	 *Metodo swap: intercambia los nodos de las listas.
**/
	@Override
	public void swap(int index1, int index2) {

	}
}