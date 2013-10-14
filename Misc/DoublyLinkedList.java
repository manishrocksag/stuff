import java.util.Iterator;
import java.util.NoSuchElementException;
public class DoublyLinkedList<Item> implements Iterable<Item> {
    private int N;
    private DoubleNode first;
    private DoubleNode last;
    private class DoubleNode{
        Item item;
        DoubleNode prev;
        DoubleNode next;
    }
    public DoublyLinkedList(){
        this.first=null;
        this.last=null;
    }
    public boolean isEmpty(){
        return first==null;
    }
    public int size(){
        return N;
    }
    public Item first()
    {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return first.item;
    }
    
    public Item last()
    {
        if (isEmpty()) throw new RuntimeException("List is empty");
        return last.item;
    }
    public void prepend(Item item){
        DoubleNode x=new DoubleNode();
        x.item=item;
        if(isEmpty()){
            first=x;
            last=x;
        }
        else{
            x.next=first;
            first.prev=x;
            first=x;
        }
        N++;
    }
    public void append(Item item){
        DoubleNode x=new DoubleNode();
        x.item=item;
        if(isEmpty()){
            first=x;
            last=x;
        }
        else{
            last.next=x;
            x.prev=last;
            last=x;
        }
        N++; 
    }
    public void insertBefore(DoubleNode node,Item item){
        DoubleNode x=new DoubleNode();
        x.item=item;
        if(node==first)
            prepend(item);
        else{
            DoubleNode prev=node.prev;
            x.prev=prev;
            x.next=node;
            prev.next=x;
            node.prev=x;
        }
        N++;
    }
    public void insertAfter(DoubleNode node,Item item){
        DoubleNode x=new DoubleNode();
        x.item=item;
        if(node==last)
            append(item);
        else{
            DoubleNode next=node.next;
            x.next=next;
            next.prev=x;
            x.prev=node;
            node.next=x;
        }
        N++;
    }
    public Item removeFirst(){
        if(isEmpty())
            throw new RuntimeException("List is empty");
        Item x=first.item;
        if(first.next!=null){
            first.next.prev=null;
            first=first.next;
            N--;
        }
        if(first==null)
            last=null;
        return x;
    }
    public Item removeLast(){
        if(isEmpty())
            throw new RuntimeException("List is empty");
        Item item=last.item;
        if(last.prev!=null){
            last.prev.next=null;
            last=last.prev;
        }
        if(last==null)
            first=null;
        N--;
        return item;
    }
    public Item remove(DoubleNode node){
         if(isEmpty())
            throw new RuntimeException("List is empty");
         if (node == first)
            return removeFirst();
        else if (node == last)
            return removeLast();
        else
        {
            DoubleNode prev = node.prev,
                       next = node.next;
            prev.next=node.next;
            next.prev=node.prev;
            N--;
        }
         return node.item; 
    } 
    @Override
   public Iterator<Item> iterator()
   {
        return new ListIterator();  
   }
   private class ListIterator implements Iterator<Item>
   {
        private DoubleNode current = first;

        @Override
        public boolean hasNext()  { return current != null;                     }
        @Override
        public void remove()      { throw new UnsupportedOperationException();  }

        @Override
        public Item next()
        {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
   }
    
    public Iterable<Item> reversed()
    {
        return new ReverseIterable();
    }
    
    private class ReverseIterable implements Iterable<Item>
    {
        @Override
        public String toString()
        {
            StringBuilder s = new StringBuilder();
            for (Item item : this)
                s.append(item).append(" ");
            return s.toString();
        }
        
        @Override
        public Iterator<Item> iterator()
        {
            return new ReverseListIterator();  
        }
    
        private class ReverseListIterator implements Iterator<Item>
        {
            private DoubleNode current = last;
    
            @Override
            public boolean hasNext()  { return current != null;                     }
            @Override
            public void remove()      { throw new UnsupportedOperationException();  }
    
            @Override
            public Item next()
            {
                if (!hasNext()) throw new NoSuchElementException();
                Item item = current.item;
                current = current.prev;
                return item;
            }
        }
    }
   @Override
   public String toString()
   {
        StringBuilder s = new StringBuilder();
        for (Item item : this)
            s.append(item).append(" ");
        return s.toString();
   } 
   
    }
