public class Tree {
    private Node root=null;
     private class Node{
         Node left;
         Node right;
         int val;
         public Node(int val){
             this.val=val;
         }
     }
     public boolean hasPathSum(int sum){
        return hasPathSum(root,sum);
    }
    private boolean hasPathSum(Node x,int sum){
        if(x==null)
            return sum==0;
        int subsum=sum-x.val;
        return (hasPathSum(x.left,subsum)||hasPathSum(x.right,subsum));
    }
    public void mirrorTree(Node x){
        if(x==null)
            return;
        mirrorTree(x.left);
        mirrorTree(x.right);
        Node temp=x.left;
        x.left=x.right;
        x.right=temp;
        }
    public void printPaths(Node root){
        int[] path=new int[100];
            printPaths(root,path,0);
    }
    private void printPaths(Node x,int[] path,int len){
        if(x==null)
            return;
        path[len++]=x.val;
        if(x.left==null&&x.right==null)
            print(path,len);
        printPaths(x.left,path,len);
        printPaths(x.right,path,len);
    }
    private void print(int[] path,int len){
        for(int i=0;i<len;i++)
            System.out.println(path[i]);    
    }
    public void doubleTree(Node root){
        if(root==null)
            return;
        doubleTree(root.left);
        doubleTree(root.right);
        Node oldLeft=root.left;
        root.left=new Node(root.val);
        root.left.left=oldLeft;    
    }
    public boolean sameTree(Node a,Node b){
        if(a==null&&b==null)
            return true;
        else if(a!=null&&b!=null)
           return  a.val==b.val&&sameTree(a.left,b.left)&&sameTree(a.right,b.right);
        return false;
    }
    public int countTrees(int x){
        if(x<=1)
            return 1;
        else{
            int sum=0;
            int left,right,root;
            for(root=1;root<=x;root++){
                left=countTrees(root-1);
                right=countTrees(x-root);
                sum+=left*right;
            }
            return sum;
        }
    }
    private int min(Node x){
        while(x.left!=null)
            x=x.left;
        return x.val;
    }
     /* Maximum key in BST */
     private int max(Node x){
          while(x.right!=null)
            x=x.right;
        return x.val;

     }
    public boolean isBST(Node x){
        if(x==null)
            return true;
        if(x.left!=null&&x.left.val<min(x.left))
            return false;
        if(x.right!=null&&x.right.val>max(x.right))
            return false;
        if(!isBST(x.left)||isBST(x.right))
            return false;
        return true; 
    }
    public boolean isBST2(Node x){
        return isBST2(x,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }
    private boolean isBST2(Node x,int min,int max){
        if(x==null)
            return true;
        if(x.val<min||x.val>max)
            return false;
        return isBST2(x.left,min,x.val)&&isBST2(x.right,x.val,max);
        
         }   
	public int sumTree(Node x){
        if(x==null)
            return 0;
        int data=x.val;
        x.val=sumTree(x.left)+sumTree(x.right);
        	return data+x.val;
    	}
   }
    
