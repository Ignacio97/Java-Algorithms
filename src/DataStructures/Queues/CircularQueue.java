package DataStructures.Queues;

import java.lang.reflect.Array;
import java.util.Iterator;

/*IMPORTANT: 1.This class MUST be used with JDK 10 or later.!! 
 * 2.The given solution sacrifice one position from the array, so the 
 *  queue capacity is SIZE, but the array length is size+1.
* */

public class CircularQueue<T> implements Queue<T> {
	private final int capacity;
	private int front;
	private int rear;
	private int size; // number of elements
	private T[] array;

	/**
	 * Constructor
	 * 
	 * @param capacity - The queue's size
	 */
	@SuppressWarnings("unchecked")
	public CircularQueue(Class<T> objClass, int capacity) {
		this.capacity = capacity + 1;
		this.size = 0;
		this.front = 0;
		this.rear = 0;
		this.array = (T[]) Array.newInstance(objClass, capacity + 1);

	}

	/**
	 * 
	 * @param item - Value to be added to queue.
	 * @throws NoSpaceAvaibleException if the queue is full-
	 */
	public void enQueue(T item) {
		if (isFull())
			throw new NoSpaceAvaibleException();

		size++;
		rear = (rear + 1) % capacity;
		array[rear] = item;

	}

	/**
	 * Removes and returns the first value of the queue.
	 * 
	 * @return first queue value.
	 * @throws EmptyQueueException
	 */
	public T deQueue() {

		if (isEmpty())
			throw new EmptyQueueException();

		size--;
		front = (front + 1) % capacity;

		return array[front];
	}

	/**
	 * Returns the first value of the queue without removing it.
	 * 
	 * @return the first value of the queue.
	 * @throws EmptyQueueException if the queue it's empty.
	 */
	public T peek() throws EmptyQueueException {

		if (isEmpty())
			throw new EmptyQueueException();

		return this.array[(this.front + 1) % this.capacity];
	}

	/**
	 * Checks if the queue is empty.
	 * 
	 * @return true if the stack is empty, otherwise false.
	 */
	public boolean isEmpty() {
		return front == rear;
	}

	/**
	 * Checks if the stack is full.
	 * 
	 * @return true if the queue is full, otherwise false.
	 */
	private boolean isFull() {
		return (front == ((rear + 1) % capacity));
	}

	/**
	 * Getter.
	 * 
	 * @return the total of elements stored in the queue.
	 */
	public int size() {
		return size;
	}

	@Override
	public Iterator<T> iterator() {
		
		return new Iterator<T>() {
			int front = CircularQueue.this.front;
			
			@Override
			public boolean hasNext() {
				return   (this.front != rear);
			}

			@Override
			public T next() {
				this.front = (this.front + 1)%capacity;
				return array[this.front];
			}
		};
	}

}

class NoSpaceAvaibleException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	NoSpaceAvaibleException() {
	}

	NoSpaceAvaibleException(String message) {
		super(message);
	}

}

class main {
	public static void main(String[] args) {
		Queue<Integer> temp = new CircularQueue<Integer>(Integer.class, 10);

		for (int i = 0; i < 10; i++)
			temp.enQueue(i);

		for(Integer x:temp) {
			System.out.print(" "+x);
		}
	}
}
