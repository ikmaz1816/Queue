package queue;
class Node<T>
{
	T data;
	Node<T> next;
	public Node(T data)
	{
		this.data=data;
	}
}
public class QueueImplementationLinkedList<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	public QueueImplementationLinkedList()
	{
		this.size=0;
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
		Node<T> n=new Node<>(value);
		if(head==null) {
			head=n;
			tail=n;
			size++;
			return;
		}
		tail.next=n;
		tail=n;
		tail.next=null;
		size++;
	}
	public void peek()
	{
		if(isEmpty())
		{
			return;
		}
		System.out.println(head.data);
	}
	public T poll() throws Exception
	{
		if(isEmpty())
			throw new Exception("Queue Empty");
		T value=head.data;
		head=head.next;
		size--;
		return value;
	}
	public static void main(String[] args) throws Exception{
		
		QueueImplementationLinkedList<Integer> q=new QueueImplementationLinkedList<>();
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
