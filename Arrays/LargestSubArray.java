public class LargestSubArray {
    
    public static int largestSubArray(int[] arr){
        int n=arr.length;
        int max_length=-1;
        int sum=0,startIndex=-1;
        for(int i=0;i<n;i++){
            sum=arr[i]==0?-1:1;
            for(int j=i+1;j<n;j++){
                if(arr[j]==0)
                    sum+=-1;
                else
                    sum+=1;
                if(sum==0 && max_length<j-i+1){
                    max_length=j-i+1;
                    startIndex=i;
             }
        }
    }
        if(max_length==-1)
            System.out.println("No such array");
        else
            System.out.printf("%d to %d",startIndex,startIndex+max_length-1);
        return max_length;
    }
}