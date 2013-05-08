package Homework_Queue;

import java.util.Iterator;
import java.util.Objects;

public class ArrayQueue<T>  implements Queue<T>,Iterable<T>{
	int front;
	int  rear;
	T [] queue;
	
	//Constructors
	
	public ArrayQueue(int initialCapcity) {
		if(initialCapcity < 1)
			throw new IllegalArgumentException
							(" InitialCapcity must be >=1");
		queue=(T[])new Object[initialCapcity+1];
		front=rear=0;
		}
	//crea una pila con tamaño Inicial de 10
	public ArrayQueue() {
			this(10);
	}
	//retorna true si esta vacia la Cola. False enn caso contrario
	public boolean isEmpty() {
	
	return front==rear;
	}
	//retorna el Elemento Front de la Cola
	//retorna Null si la pila esta vacia
	public T getFrontElement() {
	
		if(isEmpty())return null;
		else return queue[(front+1)%queue.length];
	}
	//retorna el Elemento Rear de la cola
	//retorna null si esta vacia la Cola
	public T getRearElement() {
		
		if(isEmpty())return null;
		else return queue[rear];
	}
	//Inertar un theElement  en la parte FRONT  de la Cola
	@SuppressWarnings("unchecked")
	public void put(T theElement) {
	
		if((rear + 1)% queue.length==front){
			System.out.println("Dobla tamaño de la Cola");
			//double  Array size
			//allocate a nuew array
			T[] newQueue=(T[]) new  Object[2*queue.length];
			
			
			//copy elementos al nevo array
			 int start =(front+1)%queue.length;
			 if(start<2)
				 //no wrap around 
				 System.arraycopy(queue, start, newQueue, 0, queue.length-1);
			 else
			 {
				 //queue wraps around
				 System.arraycopy(queue, start, newQueue, 0, queue.length-start);
			 	 System.arraycopy(queue, 0, newQueue, queue.length-start, rear+1);
		}
		//switch to newQueue and  set  front  and  rear
		front = newQueue.length-1;
		rear  = queue.length-2;	//queue size  is  queue.length-1
		queue = newQueue;
	}
		rear=(rear+1)%queue.length;
		queue[rear]=theElement;
		
	}
	/**
	 * Elimina un elemento desde la Front de la Cola
	 * @return el elemento removido
	 * @return null si la pila es vacia*/
	public T remove() {
	
		if(isEmpty())return null;
		
		front=(front+1)%queue.length;
		T frontElement=queue[front];
		queue[front]=null; //Elimino este elemento de la Pila Circular
		return frontElement;
	}
	public String toString() {
		StringBuilder s = new StringBuilder("[");
		
		//Poner elemento en el buffer
		for(T x:this)
			s.append(Objects.toString(x)+ ",");
		
		if(front>0)
			s.setLength(s.length()-1);//Remove last ", "
		
		s.append("]");
		//retorna el nuevo equivalente al String creado
		return new String(s);
	}
	public static void main(String[] args) {
		ArrayQueue<Integer> q= new ArrayQueue<>(3);
		
		//Addicionar un par de Elementos
		q.put(new Integer(1));
		q.put(new Integer(2));
		q.put(new Integer(3));
		q.put(new Integer(4));
		if(q.isEmpty())System.out.println("  Se Eliminaron todos los elementos de la Pila");
		//Eliminar y Añadir wraparound array doubling
		q.remove();
		q.remove();
		q.put(new Integer(5));
		q.put(new Integer(6));
		q.put(new Integer(7));
		q.put(new Integer(8));
		q.put(new Integer(9));
		q.put(new Integer(10));
		q.put(new Integer(11));
		q.put(new Integer(12));
		
		//Elminar todos los elementos
		
		while(!q.isEmpty()){
			System.out.println("EL Primer elemento de la Cola es ["+q.getFrontElement()+"]");
			System.out.println("El Ultimo elemento de la COla es ["+q.getRearElement()+"]");
			System.out.println(" El elemento eliminado es "+q.remove());
			
		}
		
	
	}
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
}
 