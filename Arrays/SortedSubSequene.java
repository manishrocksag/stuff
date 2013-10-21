public class SortedSubSequene {
    
    public static void sortedSubsequence(int[] arr){
        int n=arr.length;
        int min=0;
        int max=n-1;
        int[] smaller=new int[n-1];
        int[] greater=new int[n-1];
        
        smaller[min]=-1;
        greater[max]=-1;
        for(int i=1;i<n;i++){
            if(arr[i]<=arr[min]){
                min=i;
                smaller[i]=-1;  
            }
            else{
                smaller[i]=min;
            }
        }
        for(int i=n-2;i>=0;i++){
            if(arr[i]<arr[max]){
                greater[i]=max;
            }
            else{
                greater[i]=-1;
                max=i;
            }
        }
        for(int i=0;i<n;i++){
            if(smaller[i]!=-1&&greater[i]!=-1){
                System.out.printf("%d\t%d\t%d\t",arr[smaller[i]],arr[i],arr[greater[i]]);
            }
        }
        
    }
    
}
