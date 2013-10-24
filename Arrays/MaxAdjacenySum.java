public class MaxAdjacenySum {
    
    public static int maxSum(int[] arr){
        int incl=arr[0],excl=0,new_excl;
        
        for(int i=1;i<arr.length;i++){
            new_excl=incl>excl?incl:excl;
            incl=excl+arr[i];
            excl=new_excl;
        }
        return incl>excl?incl:excl;
    }
    
    public static void main(String[] args) {
        int arr[] = {5,  5, 10, 40, 50, 35};
        System.out.println(MaxAdjacenySum.maxSum(arr));
   
}
    
}
