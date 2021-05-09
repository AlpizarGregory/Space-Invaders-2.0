package DataStructures;

/**
 *Interfaz List: Es la interface de las listas con los metodos
 * que comparten entre sí.
 */
public interface List<Class> {

/**
 *Metodo add: agrega un valor a la lista.
*/
	public void add(Class value);
/**
	 *Metodo remove: remueve un valor de la lista.
*/
	public void remove(int index);

/**
	 *Metodo get: retorna un valor de la lista.
*/
	public Class get(int index);
/**
	 *Metodo size: retorna el tamaño de la lista.
 * */
	public int size();
	/**
	 *Metodo clear: vacia el nodo.
	 * */
	public void clear();
/**
	 *Metodo swap: intercambia los nodos de las listas.
**/
	public void swap(int index1, int index2);
}
