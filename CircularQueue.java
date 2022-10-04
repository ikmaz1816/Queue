package queue;

public class CircularQueue<T> {
	private T[] arr;
	private int index;
	private int front;
	private int end;
	private static final int CAPACITY=5;
	@SuppressWarnings("unchecked")
	public CircularQueue()
	{
		arr=(T[]) new Object[CAPACITY];
		this.front=0;
		this.end=0;
		this.index=0;
	}
	public int size()
	{
		return this.index;
	}
	public boolean isEmpty()
	{
		return this.index==0;
	}
	@SuppressWarnings("unchecked")
	private void doubleArray()
	{
		T[] arr1=arr;
		arr=(T[])new Object[arr1.length * 2];
		for(int i=0;i<arr1.length;i++)
		{
			arr[i]=arr1[(front+i)%arr1.length];
		}
		end=arr1.length;
	}
	public void offer(T value)
	{
		if(index==arr.length)
			doubleArray();
		arr[end%arr.length]=value;
		end++;
		index++;
	}
	public T poll() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue Empty");
		T value=arr[front%arr.length];
		arr[front]=null;
		front++;
		index--;
		return value;
	}
	public void display()
	{
		int value=front;
		do
		{
			if(arr[value]!=null)
			System.out.println(arr[value]);
			value++;
			value=value%arr.length;
		}while(value!=front);
	}
	public void peek()
	{
		if(isEmpty())
			return;
		System.out.println(arr[front]);
	}
	public static void main(String[] args) throws Exception{
		CircularQueue<Integer> c=new CircularQueue<>();
		c.offer(1);
		c.offer(2);
		c.offer(3);
		c.offer(4);
		c.offer(5);
		c.offer(6);
		
		c.peek();
		System.out.println();
		c.display();
		System.out.println();
		System.out.println(c.poll());
		System.out.println();
		
		c.display();
	}

}
