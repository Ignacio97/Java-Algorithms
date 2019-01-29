package DataStructures.Lists;

import java.util.Iterator;
import DataStructures.Utils.Node;

public class ListIterator<T> implements Iterator<T> {
	Node<T> head = null;

	public ListIterator(Node<T> head) {
		this.head = head;
	}

	@Override
	public boolean hasNext() {

		return (head != null);
	}

	@Override
	public T next() {
		T item = head.item;
		head = head.next;
		return item;
	}

}
