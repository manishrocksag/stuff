import java.util.Iterator;
public class Queue<Item> implements Iterable<Item> {

    private  class QueueIterator implements Iterator<Item> {

        public QueueIterator() {
        }

        @Override
        public boolean hasNext() {
            return (!isEmpty());
        }

        @Override
        public Item next() {
            Item item=head.item;
            head=head.next;
            tail=head;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    private Node head,tail;

    @Override
    public Iterator<Item> iterator() {
        return new QueueIterator();
    }
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void enqueue(Item item){
        Node oldlast=tail;
        tail=new Node();
        tail.item=item;
        tail.next=null;
        if(isEmpty())
            head=tail;
        else
            oldlast.next=tail;
    }
    public Item dequeue(){
        assert(!isEmpty());
        Item item=head.item;
        head=head.next;
        if(isEmpty())
            tail=null;
        return item; 
    }
}