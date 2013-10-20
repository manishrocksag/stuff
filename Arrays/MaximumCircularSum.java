public class MaximumCircularSum {
    private static int kadane(int[] arr){
        int n=arr.length;
        int max_so_far=0;
        int max_ending_here=0;
        for(int i=0;i<n;i++){
            max_ending_here=max_ending_here + arr[i];
            if(max_ending_here<0)
                max_ending_here=0;
            if(max_so_far<max_ending_here)
                max_so_far=max_ending_here;
        }
        return max_so_far;
    }
    public static int largestCircularSum(int[] arr){
        int n=arr.length;
        int max_kadane=kadane(arr);
        int max_wrap=0;
        for(int i=0;i<n;i++){
            max_wrap+=arr[i];
            arr[i]=-arr[i];
        }
        max_wrap=max_wrap+kadane(arr);
        return max_wrap>max_kadane?max_wrap:max_kadane; 
    }
    public static void main(String[] args) {
        int a[] =  {11, 10, -20, 5, -3, -5, 8, -13, 10};
        System.out.println(MaximumCircularSum.largestCircularSum(a));
    
}
}
