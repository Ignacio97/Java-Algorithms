
/**
 * This class (DynamicQueue) implements a dynamic queue using nodes. 
 *
 * IMPORTANT: You MUST use these classes with JDK 10 or later.!!
 *
 */
package DataStructures.Queues;

import java.util.Iterator;

import DataStructures.Lists.ListIterator;
import DataStructures.Utils.Node;

public class DynamicQueue<T> implements Queue<T> {

	private Node<T> head;
	private Node<T> tail;
	private int size;

	/**
	 * Constructor
	 */
	public DynamicQueue() {
		this.head = this.tail = null;
		this.size = 0;
	}

	/**
	 *
	 * @param item - Value to be added to queue.
	 *
	 */
	public void enQueue(T item) {
		size++; // increment size.

		// if the queue its empty.
		if (tail == null)
			tail = this.head = new Node<T>(item);
		else
			tail = tail.next = new Node<T>(item);

	}

	/**
	 * Removes and returns the first value of the queue.
	 *
	 * @return first queue value.
	 * @throws EmptyQueueException
	 */
	public T deQueue() {
		T aux;

		if (isEmpty())
			throw new EmptyQueueException();

		aux = head.item;

		head = head.next;

		if (head == null)
			tail = null;

		size--; // decrement size;

		return aux;
	}

	/**
	 * Returns the first value of the queue without removing it.
	 *
	 * @return the first value of the queue.
	 * @throws EmptyQueueException if the queue it's empty.
	 */
	public T peek() {

		if (isEmpty())
			throw new EmptyQueueException();

		return head.item;
	}

	/**
	 * Checks if the queue is empty.
	 * 
	 * @return true if the stack is empty, otherwise false.
	 */
	public boolean isEmpty() {
		return (this.size == 0);
	}

	/**
	 * Getter.
	 * 
	 * @return the total of elements stored in the queue.
	 */
	public int size() {
		return this.size;
	}

	@Override
	public Iterator<T> iterator() {
		return new ListIterator<T>(head);
	}

}
