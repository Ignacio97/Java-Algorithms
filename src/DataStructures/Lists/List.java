package DataStructures.Lists;


public interface List<T> extends Iterable<T> {

	public void add(T item, int index) ;

	public void add(T item);

	public void addLast(T item);

	public void clear();

	public boolean contains(T item);

	public T get(int index) ;

	public boolean isEmpty();

	public T remove(int index) ;

	public int size();
}