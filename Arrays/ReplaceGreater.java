public class ReplaceGreater {
    public static void replaceWithNextGreater(int[] arr){
        int n=arr.length;
        int max_from_right=arr[n-1];
          arr[n-1]=-1;
        for(int i=n-2;i>=0;i--){
            int temp=arr[i];
            arr[i]=max_from_right;
            if(temp>max_from_right)
                max_from_right=temp;  
        }
        for(int i=0;i<n;i++)
            System.out.println(arr[i]);
                System.out.println("");
        
    }
    public static void main(String[] args) {
    int arr[] = {16, 17, 4, 3, 5, 2};
    ReplaceGreater.replaceWithNextGreater(arr);
}
    
}
