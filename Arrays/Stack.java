import java.util.Iterator;
public class Stack<Item> implements Iterable<Item> {
    private Node head=null;
    private  class StackIterator implements Iterator<Item> {
        @Override
        public boolean hasNext() {
            return (!isEmpty());
        }
        @Override
        public Item next() {
            Item item=head.item;
            head=head.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not supported yet.");
        }
    }
    @Override
    public Iterator<Item> iterator() {
        return new StackIterator();
    }
    private class Node{
        Item item;
        Node next;
    }
    public boolean isEmpty(){
        return head==null;
    }
    public void push(Item item){
        Node oldFirst=head;
        head=new Node();
        head.item=item;
        head.next=oldFirst;
    }
    public Item pop(){
        assert(!isEmpty());
        Item item=head.item;
        head=head.next;
        return item; 
    }
    public Item top(){
        Item item=head.item;
        return item;
    }
    public static void main(String[] args) {
   Stack<Integer> obj=new Stack<>();
   obj.push(0);
   obj.push(1);
   obj.push(2);
        System.out.println(obj.pop());
        System.out.println(obj.pop());
        System.out.println(obj.pop());
     
}    
}
