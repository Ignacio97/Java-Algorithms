package DataStructures.Lists;

import DataStructures.Utils.Node;

public class SinglyLinkedList<T> extends AbstractList<T> {

	@Override
	public void add(T item) {

		head = new Node<T>(item, head);

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

			tmp.next = new Node<T>(item, null);
		}

		size++;
	}

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

			tmp.next = new Node<T>(item, tmp.next);

		}

		size++;
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

		if (index == 0) {
			removed = head.item;
			head = head.next;
		} else {
		
			 while (++i < index)
				prev = prev.next;

			removed = prev.next.item;
			prev.next = prev.next.next;
		}

		size--;
		return removed;
	}

}