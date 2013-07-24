public class Bag<Item> implements Iterable<Item>
{
	private Node root=null;
	private class Node
	{
		Item item;
		Node next;
	}
	public void add(Item item)
	{
		Node oldfirst=root;
		root=new Node();
		root.item=item;
		root.next=oldfirst;
	}
	public Iterator<Item> iterator()
	{
		return new ListIterator();
	}
	private class ListIterator implements Iterator<Item>
	{
		private Node current=root;
		public boolean hasNext()
		{
			return current!=null;
		}
		public void remove(){}
		public Item next()
		{
			Item item=current.item;
			current=current.next;
			return item;
		}
	}
}
		

