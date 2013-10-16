public class MaxSubArray {
    
    private static int max(int a,int b){
        return a >b ?a:b;
    }
    private static int max(int a,int b,int c){
        return max(max(a,b),c);
    }
    private static int maxCrossingSum(int[] arr,int low,int high){
        int mid=low + (high-low)/2;
        int max_left_sum=Integer.MIN_VALUE;
        int max_right_sum=Integer.MIN_VALUE;
        int leftSum=0,rightSum=0;
        
        //left sum
        for(int left=mid;left>=low;left--){
            leftSum+=arr[left];
            if(leftSum > max_left_sum)
                max_left_sum=leftSum;
        }
        for(int right=mid+1;right<=high;right++){
            rightSum+=arr[right];
            if(rightSum > max_right_sum)
                max_right_sum=rightSum;
        }
        return max_left_sum + max_right_sum;
        
    }
    public static int maxSubArraySum(int[] arr,int low,int high){
        if(low==high)
            return arr[low];
        int mid=low + (high-low)/2;
        return max(maxSubArraySum(arr, low, mid),maxSubArraySum(arr, mid+1, high),maxCrossingSum(arr, low, high));
        
    }
    public static void main(String[] args) {
     int arr[] = {-90, -3, -4, -5, -7};
        System.out.println(MaxSubArray.maxSubArraySum(arr, 0, arr.length-1));
     
}
    
    
}
