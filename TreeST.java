public class TreeST<Key extends Integer,Value> {
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
    /* is the symbol table empty? */
    public boolean isEmpty() {
        return size() == 0;
    }
    /* Search for keys */
    public boolean contains(Key key) {
        return get(key) != null;
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
    /* Insertion in BST */
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
        System.out.println("Count is:"+x.count+ "and key is"+x.key);
        return x;
    }
    /* Minimum key in BST */
    public Key min(){
        Node x= min(root);
        return x.key;
    }
    private Node min(Node x){
        while(x.left!=null)
            x=x.left;
        return x;
    }
     /* Maximum key in BST */
     public Key max(){
        Node x= max(root);
        return x.key;
           }
     private Node max(Node x){
          while(x.right!=null)
            x=x.right;
        return x;

     }
      /* Floor in BST */
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
     /* Ceiling in BST */
    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) return null;
        else return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) return null;
        int cmp = key.compareTo(x.key);
        if (cmp == 0) return x;
        if (cmp < 0) { 
            Node t = ceiling(x.left, key); 
            if (t != null) return t;
            else return x; 
        } 
        return ceiling(x.right, key); 
    } 
     /* Size of BST */
    public int size(){
        return size(root);
    }
    private int size(Node x){
        if(x==null)
            return 0;
        return x.count;
    }
     /* Depth of BST */
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
     /* Rank of a key in BST */
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
     /*Deletion in BST */
    public void delMin(){
       root= delMin(root);
    }
    private Node delMin(Node x){
        if(x.left==null)
            return x.right;
        x.left=delMin(x.left);
        x.count=1+size(x.left)+size(x.right);
        return x;  
    }
     public void delMax(){
       root= delMax(root);
    }
    private Node delMax(Node x){
        if(x.right==null)
            return x.left;
        x.right=delMin(x.right);
        x.count=1+size(x.left)+size(x.right);
        return x;
        
    }
    /* Hibbard Deletion */
    public void delete(Key key){
        root=delete(root,key);
    }
    private Node delete(Node x,Key k){
        if(x==null)
            return null;
        int cmp=k.compareTo(x.key);
        if(cmp<0)
            x.left=delete(x.left,k);
        else if(cmp>0)
            x.right=delete(x.right,k);
        else{
            if(x.right==null)
                return x.left;
            if(x.left==null)
                return x.right;
            Node t=x;
            x=min(t.right);
            x.right=delMin(x.right);
            x.left=t.left;
        }
        x.count=1+size(x.left)+size(x.right);
        return x;
    }
     /* Inorder Traversal in BST */
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
    /*PostOrder traversal in BST */
     public Iterable<Key> postorder(){
        Queue<Key> q=new Queue<>();
        postorder(root,q);
        return q;    
    }
    private void postorder(Node x,Queue<Key> q){
        if(x==null)
            return;
        postorder(x.left,q);
        postorder(x.right,q);
        q.enqueue(x.key);
    
    }
      /*LevelOrder traversal in BST */
     public Iterable<Key> levelOrder() {
        Queue<Key> keys = new Queue<>();
        Queue<Node> queue = new Queue<>();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node x = queue.dequeue();
            if (x == null) continue;
            keys.enqueue(x.key);
            queue.enqueue(x.left);
            queue.enqueue(x.right);
        }
        return keys;
    }
    /*  Range count and range search.*/
    public Iterable<Key> keys() {
        return keys(min(), max());
    }

    public Iterable<Key> keys(Key lo, Key hi) {
        Queue<Key> queue = new Queue<>();
        keys(root, queue, lo, hi);
        return queue;
    } 
    private void keys(Node x, Queue<Key> queue, Key lo, Key hi) { 
        if (x == null) return; 
        int cmplo = lo.compareTo(x.key); 
        int cmphi = hi.compareTo(x.key); 
        if (cmplo < 0) keys(x.left, queue, lo, hi); 
        if (cmplo <= 0 && cmphi >= 0) queue.enqueue(x.key); 
        if (cmphi > 0) keys(x.right, queue, lo, hi); 
    } 

    public int size(Key lo, Key hi) {
        if (lo.compareTo(hi) > 0) return 0;
        if (contains(hi)) return rank(hi) - rank(lo) + 1;
        else              return rank(hi) - rank(lo);
    }
}