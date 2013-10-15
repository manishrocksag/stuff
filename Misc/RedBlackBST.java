public class RedBlackBST<Key extends Comparable<Key>,Value> {
    private static final boolean RED=true;
    private static final boolean BLACK=false;
    private Node root;
    private int N;
    private class Node{
        Key key;
        Value val;
        private int N;
        Node left,right;
        private boolean color; 
        public Node(Key key,Value val,boolean color){
            this.key=key;
            this.val=val;
            this.color=color;
        }
     }
    // is node x red; false if x is null
    private boolean isRed(Node x){
        if(x==null)return false;
        return x.color==RED;
    }
    private int size(Node x){
        if(x==null)
            return 0;
        else
            return x.N;
    }
     // return value associated with the given key, or null if no such key exists
    public Value get(Key key) { return get(root, key); }
    public Value get(Node x, Key key) {
        while (x != null) {
            int cmp = key.compareTo(x.key);
            if      (cmp < 0) x = x.left;
            else if (cmp > 0) x = x.right;
            else              return x.val;
        }
        return null;
    }

    // is there a key-value pair in the symbol table with the given key?
    public boolean contains(Key key) {
        return (get(key) != null);
    }
    //Insertion in RedBlackTrees
    public void put(Key key,Value val){
        root=put(root,key,val);
        root.color=BLACK;
        assert check();
    }
    private Node put(Node x,Key key,Value val){
        if(x==null){
            N++;
            return new Node(key,val,RED);
        }
        int cmp=key.compareTo(x.key);
        if(cmp<0)
            x.left=put(x.left,key,val);
        else if(cmp>0)
            x.right=put(x.right,key,val);
        else
            x.val=val;
        if(isRed(x.right)&&(!isRed(x.left)))
            x=rotateLeft(x);
        if(isRed(x.left)&&(isRed(x.left.left)))
            x=rotateRight(x);
        if(isRed(x.left)&&(isRed(x.right)))
            flipColors(x);
        return x;   
    }
    private Node rotateLeft(Node h){
        assert (h != null) && isRed(h.right);
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
    private Node rotateRight(Node h){
        assert (h != null) && isRed(h.right);
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        return x;
    }
     private void flipColors(Node h) {
        assert !isRed(h) && isRed(h.left) && isRed(h.right);
        h.color = RED;
        h.left.color = BLACK;
        h.right.color = BLACK;
    }
         private boolean check() {
        if (!isBST())            System.out.println("Not in symmetric order");
        if (!is23())             System.out.println("Not a 2-3 tree");
        if (!isBalanced())       System.out.println("Not balanced");
        return isBST() && is23() && isBalanced();
    }

    // does this binary tree satisfy symmetric order?
    // Note: this test also ensures that data structure is a binary tree since order is strict
    private boolean isBST() {
        return isBST(root, null, null);
    }

    // is the tree rooted at x a BST with all keys strictly between min and max
    // (if min or max is null, treat as empty constraint)
    // Credit: Bob Dondero's elegant solution
    private boolean isBST(Node x, Key min, Key max) {
        if (x == null) return true;
        if (min != null && x.key.compareTo(min) <= 0) return false;
        if (max != null && x.key.compareTo(max) >= 0) return false;
        return isBST(x.left, min, x.key) && isBST(x.right, x.key, max);
    } 

    // Does the tree have no red right links, and at most one (left)
    // red links in a row on any path?
    private boolean is23() { return is23(root); }
    private boolean is23(Node x) {
        if (x == null) return true;
        if (isRed(x.right)) return false;
        if (x != root && isRed(x) && isRed(x.left))
            return false;
        return is23(x.left) && is23(x.right);
    } 

    // do all paths from root to leaf have same number of black edges?
    private boolean isBalanced() { 
        int black = 0;     // number of black links on path from root to min
        Node x = root;
        while (x != null) {
            if (!isRed(x)) black++;
            x = x.left;
        }
        return isBalanced(root, black);
    }

    // does every path from the root to a leaf have the given number of black links?
    private boolean isBalanced(Node x, int black) {
        if (x == null) return black == 0;
        if (!isRed(x)) black--;
        return isBalanced(x.left, black) && isBalanced(x.right, black);
  	}
}