package queue;

public class QueueArrayImplementaion<T> {
	private T[] arr;
	private int index;
	private static final int CAPACITY=5;
	
	public QueueArrayImplementaion()
	{
		this(CAPACITY);
	}
	@SuppressWarnings("unchecked")
	public QueueArrayImplementaion(int size)
	{
		arr=(T[])new Object[size];
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
			arr[i]=arr1[i];
		}
	}
	public void offer(T value)
	{
		if(index==arr.length)
			doubleArray();
		arr[index++]=value;
	}
	public T poll() throws Exception
	{
		if(index<0)
			throw new Exception("Stack Empty");
		T value=arr[0];
		for(int i=1;i<arr.length;i++)
		{
			arr[i-1]=arr[i];
		}
		index--;
		return value;
	}
	public void peek()
	{
		if(index<0)
		{
			return;
		}
		System.out.println(arr[0]);
	}
	public static void main(String[] args) throws Exception{
		QueueArrayImplementaion<Integer> q=new QueueArrayImplementaion<>();
		q.offer(1);
		q.offer(2);
		q.offer(3);
		q.offer(4);
		q.offer(5);
		q.offer(6);
		System.out.println(q.size());
		q.peek();
		
		while(!q.isEmpty())
		{
			System.out.println(q.poll());
		}
	}

}
