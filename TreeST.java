public class TreeST<Key extends Comparable<Key>,Value> {
    private Node root=null;
    private class Node{
        Node left;
        Node right;
        Key key;
        Value val;  
        int count;
    public Node(Key key,Value val){
        this.key=key;
        this.val=val;
        
        }
     }
    public Value get(Key key){
        Node x=root;
        while(x!=null){
        int cmp=key.compareTo(x.key);
        if(cmp<0)
            x=x.left;
        else if(cmp>0)
            x=x.right;
        else
            return x.val;
        }
        return null; 
    }
    public void put(Key key,Value val){
        root=put(root,key,val);
    }
    private Node put(Node x,Key key,Value val){
        if(x==null)
            return new Node(key,val);
        int cmp=key.compareTo(x.key);
        if(cmp<0)
            x.left=put(x.left,key,val);
        else if(cmp>0)
            x.right=put(x.right,key,val);
        else
            x.val=val;
        x.count=1+size(x.left)+size(x.right);
        return x;
    }
    public Key max(){
        Node x=root;
        while(x.left!=null)
            x=x.left;
        return x.key;
    }
    public Key floor(Key key){
        Node x=floor(root,key);
        if(x==null)
            return null;
        else
            return x.key;
    }
    private Node floor(Node x,Key key){
        if(x==null)
            return null;
        int cmp=key.compareTo(x.key);
        if(cmp==0)
            return x;
        if(cmp<0)
            return floor(x.left,key);
        Node t=floor(x.right,key);
        if(t!=null)
            return t;
        else
            return x;
    }
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x==null)
            return 0;
        return x.count;
    }
    public int rank(Key key){
        return rank(root,key);
    }
    private int rank(Node x,Key k){
        if(x==null)
            return 0;
        int cmp=k.compareTo(x.key);
        if(cmp<0)
            return rank(x.left,k);
        else if(cmp>0)
            return 1+size(x.left)+rank(x.right,k);
        else
            return size(x.left);
    }
    public Iterable<Key> inorder(){
        Queue<Key> q=new Queue<>();
        inorder(root,q);
        return q;    
    }
    private void inorder(Node x,Queue<Key> q){
        if(x==null)
            return;
        inorder(x.left,q);
        q.enqueue(x.key);
        inorder(x.right,q);
    
    }
    public int maxDepth(){
       return maxDepth(root);
    }
    private int maxDepth(Node x){
        if(x==null)
            return 0;
        int lDepth=maxDepth(x.left);
        int rDepth=maxDepth(x.right);
        if(lDepth>rDepth)
            return lDepth+1;
        else
            return rDepth+1;
    }
}