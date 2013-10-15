public class TreeList {
    private class Node{
        int data;
        Node small;
        Node large;
        public Node(int data){
            this.data=data;
            small=null;
            large=null;
        }   
    }
    public void join(Node a,Node b){
        a.large=b;
        b.small=a;
    }
    public Node append(Node a,Node b){
        if(a==null)
            return b;
        if(b==null)
            return a;
        Node aLast=a.small;
        Node bLast=b.small;
        join(aLast,b);
        join(bLast,a);
        return a;    
    }
    public Node treeToList(){
        
        return treeToList(root);
    }    
    private Node treeToList(Node root){
        if(root==null)
            return null;
        Node aList=treeToList(root.small);
        Node bList=treeToList(root.large);
        root.small=root;
        root.large=root;
        aList=append(aList,root);
        aList=append(aList,bList);
        return aList;  
    }
    private Node root=null;
   public void insert(int val){
        root=put(root,val);
    }
    private Node put(Node x,int val){
        if(x==null)
            return new Node(val);
        if(val<x.data)
            x.small=put(x.small,val);
        else if(val>x.data)
            x.large=put(x.large,val);
        else
            x.data=val;
        return x;
    }
    public  void printTree(){
        
        printTree(root);
    }     
    private  void printTree(Node root) {
        if (root==null) return;
            printTree(root.small);
            System.out.print(Integer.toString(root.data) + " ");
            printTree(root.large);
    }
        // Do a traversal of the list and print it out
    public static void printList(Node head) {
        Node current = head;
            while (current != null) {
        System.out.print(Integer.toString(current.data) + " ");
             current = current.large;
         if (current == head) break;
                }
       System.out.println();
    }
    public static void main(String[] args) {
     TreeList obj=new TreeList();
        obj.insert(4);
        obj.insert(2);
        obj.insert(1);
        obj.insert(3);
        obj.insert(5);

        obj.printTree(); // 1 2 3 4 5
        System.out.println();
        System.out.println("list:");
        Node head = obj.treeToList();
        printList(head); // 1 2 3 4 5 yay!
    }
}
        
