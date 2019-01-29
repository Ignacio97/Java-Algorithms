package DataStructures.Queues;

public interface Queue<T> extends Iterable<T>{

	public void enQueue(T item);

	public T deQueue();

	public T peek();
	
	public boolean isEmpty();
	
	public int size();

}
