package queue;

import java.util.Stack;

public class QueueUsingTwoStack<T> {
	private Stack<T> s1;
	private Stack<T> s2;
	private int size;
	public QueueUsingTwoStack()
	{
		this.size=0;
		s1=new Stack<T>();
		s2=new Stack<T>();
	}
	public int size()
	{
		return this.size;
	}
	public boolean isEmpty()
	{
		return this.size==0;
	}
	public void offer(T value)
	{
		size++;
		while(!s1.isEmpty())
		{
			s2.add(s1.pop());
		}
		s1.add(value);
		while(!s2.isEmpty())
		{
			s1.add(s2.pop());
		}
	}
	public T poll() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue is Empty");
		size--;
		return s1.pop();
	}
	public void peek()
	{
		if(isEmpty())
			return;
		System.out.println(s1.peek());
	}
	public static void main(String[] args)  throws Exception{
		QueueUsingTwoStack<Integer> q=new QueueUsingTwoStack<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		
		q.peek();
		
		while(!q.isEmpty())
		{
			System.out.println(q.poll());
		}
	}

}
