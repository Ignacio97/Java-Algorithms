package DataStructures.Lists;



import java.util.Iterator;
import DataStructures.Utils.Node;

public abstract class AbstractList<T> implements List<T> {

	protected Node<T> head = null;
	protected int size = 0;

	public Iterator<T> iterator() {
		return new ListIterator<T>(this.head);
	}

	@Override
	public boolean contains(T item) {
		Iterator<T> it = this.iterator();

		while (it.hasNext())
			if (it.next().equals(item))
				return true;

		return false;
	}

	@Override
	public boolean isEmpty() {

		return (head == null);
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public void clear() {
		head = null;
		size = 0;
	}

}
