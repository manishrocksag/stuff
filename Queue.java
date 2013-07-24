import java.util.Iterator;
public class Queue<Item> implements Iterable<Item> {
    private Node head=null;
    private Node tail=null;
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
        Node x=new Node();
        x.item=item;
        if(isEmpty()){
            head=x;
        }
        else{
            tail.next=x;
            tail=tail.next;
        }
    }
    public Item dequeue(){
        assert(!isEmpty());
        Item item=head.item;
        head=head.next;
        return item; 
    }
    private  class QueueIterator implements Iterator<Item> {
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
            throw new UnsupportedOperationException("Not    supported yet.");
        }
    }  
}