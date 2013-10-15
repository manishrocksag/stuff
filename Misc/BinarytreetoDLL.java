public class BinarytreetoDLL {
    private class Node{
        Node left;
        Node right;
        int val;
    }
    Node root=null;
    public Node convert(Node root){
        if(root==null)
            return root;
        if(root.left!=null){
            Node left=convert(root.left);
            for(;left.right!=null;left=left.right);
            left.right=root;
            root.left=left;
            
        }
        if(root.right!=null){
            Node right=convert(root.right);
            for(;right.left!=null;right=right=right.left);
            right.left=root;
            root.right=right;
        }
        return root;
        
    }
    public Node toList(Node root){
        if(root==null)
            return root;
        root=convert(root);
        while(root.left!=null)
            root=root.left;
        return root;
    }
    
}
