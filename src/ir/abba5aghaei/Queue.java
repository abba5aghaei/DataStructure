package ir.abba5aghaei;
public class Queue {
	
	QueueNode front;
	QueueNode rear;
	int size;
	
	public void insert(Object item) {
		
		if(isEmpty())
		{
			rear = new QueueNode(item);
			front = rear;
		}
		else {
			
			rear.link = new QueueNode(item);
			
			rear = rear.link;
		}
		size++;
	}
	public Object remove() {
		
		QueueNode oldFront = front;
		
		Object item = peek();
		
		front = front.link;
		
		oldFront.link = null;
		
		size--;
		
		return item;
	}
	public Object peek() {
		
		if(isEmpty())
			throw new NullPointerException();
		return front.info;
	}
	public boolean isEmpty() {
		
		return (size == 0);
	}
	public int getSize() {
		
		return size;
	}
}
