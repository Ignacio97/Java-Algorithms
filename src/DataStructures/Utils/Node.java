package DataStructures.Utils;

public class Node<T> {
	
	public T item = null;
	public  Node<T> next = null;
	public Node<T> previous = null;

	public Node(T item, Node<T> previous, Node<T> next) {
		this.item = item;
		this.next = next;
		this.previous = previous;
	}

	public Node(T item, Node<T> next) {
		this(item, null, next);
	}

	public Node(T item) {
		this(item, null);
	}

}
