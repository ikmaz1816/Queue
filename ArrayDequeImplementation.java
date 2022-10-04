package queue;

public class ArrayDequeImplementation<T> {
	private T[] arr;
	private int size;
	private int front;
	private int end;
	private static final int CAPACITY=5;
	public ArrayDequeImplementation()
	{
		this(CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public ArrayDequeImplementation(int size)
	{
		this.size=0;
		this.front=0;
		this.end=0;
		arr=(T[]) new Object[size];
	}
	public int size()
	{
	return this.size;
	}
	public boolean isEmpty()
	{
		return this.size==0;
	}
	public void addFirst(T value)
	{
		if(size==arr.length)
			return;
		if(isEmpty())
		{
			arr[front]=value;
		}
		else
		{
			front=(front-1+arr.length)%arr.length;
			arr[front]=value;
		}
		size++;
	}
	public void addLast(T value)
	{
		if(size==arr.length)
			return;
		if(isEmpty())
		{
			arr[end]=value;
		}
		else
		{
			end=(end+1+arr.length)%arr.length;
			arr[end]=value;
		}
		size++;
	}
	public T removeFirst() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue Empty");
		T value=arr[front];
		arr[front]=null;
		front=(front+1+arr.length)%arr.length;
		size--;
		return value;
		
	}
	public T removeLast() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue Empty");
		T value=arr[end];
		arr[end]=null;
		end=(end-1+arr.length)%arr.length;
		size--;
		return value;
		
	}
	public void display()
	{
		int i=front;
		do
		{
			if(arr[i]!=null)
			System.out.print(arr[i]+" ");
			i++;
			i=i%arr.length;
		}while(i!=front);
		System.out.println();
	}
	public static void main(String[] args) throws Exception{
		ArrayDequeImplementation<Integer> arr=new ArrayDequeImplementation<>();
		arr.addFirst(1);
		arr.addLast(2);
		arr.addLast(3);
		arr.addFirst(4);
		arr.addLast(9);
		
		arr.display();
		
		arr.removeFirst();
		arr.display();
		
		arr.removeLast();
		arr.display();
		
		System.out.println(arr.size());
	}
}
