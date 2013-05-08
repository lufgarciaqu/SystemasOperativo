package Homework_Queue;

public interface Queue<T> {

	boolean isEmpty();
	T getFrontElement();
	T getRearElement();
	void put(T theObject);
	T remove();
}
