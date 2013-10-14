import java.util.ArrayList;
public class IdenticalBST {
    public boolean checkIdenticalBST(ArrayList<Integer> a1,ArrayList<Integer> b1){
        if(a1.size()!=b1.size())
            return false;
        if(a1.isEmpty()&&b1.isEmpty())
            return true;
        if(a1.get(0)!=b1.get(0))
            return false;
         
            ArrayList<Integer> left1 = new ArrayList<>();
            ArrayList<Integer> right1= new ArrayList<>();
            ArrayList<Integer> left2 = new ArrayList<>();
            ArrayList<Integer> right2 = new ArrayList<>();
             
            int n = a1.size();
            int root = a1.get(0);
             
            //create the left subtree and rightsubtree
            for(int i =1;i<n;i++){ // start with 1 !!! as index
                if(a1.get(i)<root){
                    left1.add(a1.get(i));
                }
                else{
                    right1.add(a1.get(i));
                }
                 
                // do same for next arra
                if(b1.get(i)<root){
                    left2.add(b1.get(i));
                }
                else{
                    right2.add(b1.get(i));
                }
            }
         
            return checkIdenticalBST(left1, left2) && checkIdenticalBST(right1, right2);
             
        }
        
        
    }
    

