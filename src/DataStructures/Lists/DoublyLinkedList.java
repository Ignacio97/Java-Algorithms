package DataStructures.Lists;

import DataStructures.Utils.Node;

public class DoublyLinkedList<T> extends AbstractList<T> {

	@Override
	public void add(T item, int index) {
		Node<T> tmp = head;
		int i = 0;

		if (index >= size() || index < 0)
			throw new IndexOutOfBoundsException();

		if (item == null)
			throw new NullPointerException();

		if (index == 0) {
			add(item);
		} else if (index + 1 == size()) {
			addLast(item);
		} else {

			while (++i < index)
				tmp = tmp.next;

			tmp.next = tmp.next.previous = new Node<T>(item, tmp, tmp.next);
		}
		size++;
	}

	@Override
	public void add(T item) {
		if (isEmpty())
			head = new Node<T>(item, head, head);
		else
			head = head.previous = new Node<T>(item, null, head);
		
		size++;
	}

	@Override
	public void addLast(T item) {
		Node<T> tmp = head;

		if (isEmpty()) {
			add(item);
		} else {
			while (tmp.next != null)
				tmp = tmp.next;

			tmp.next = new Node<T>(item, tmp, null);
		}
	}

	@Override
	public T get(int index) {
		Node<T> tmp = head;

		int i = 0;

		if (isEmpty())
			throw new NullPointerException("the list is empty");

		if (index >= size() || index < 0)
			throw new IndexOutOfBoundsException();

		while (i++ < index)
			tmp = tmp.next;

		return tmp.item;
	}

	@Override
	public T remove(int index) {
		T removed = null;
		Node<T> prev = head;
		int i = 0;

		if (isEmpty())
			throw new NullPointerException("the list is empty");

		if (index >= size() || index < 0)
			throw new IndexOutOfBoundsException();

		while (i++ < index)
			prev = prev.next;

		removed = prev.item;

		if (index == 0) {
			head = head.next;
			if (head != null)
				head.previous = null;
		} else if (prev.next == null) {
			prev.previous.next = null;
		} else {
			prev.previous.next = prev.next;
			prev.next.previous = prev.previous;
		}

		size--;
		return removed;
	}

}
