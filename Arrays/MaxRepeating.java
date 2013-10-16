public  class MaxRepeating {
    public static int findMaxRepeatingElemrnt(int[] arr){
        
        int length=arr.length;
        int k=arr.length-1;
        for(int i=0;i<length-1;i++){
            arr[arr[i]%k]+=k;
        }
        int max=arr[0];
        int result=0;
        for(int i=1;i<length-1;i++){
            if(arr[i]>max)
            {
                max=arr[i];
                result=i;
            }
        }
        return result;
        
    }
    public static void main(String[] args) {
   
        int arr[] = {2, 6, 6, 5, 6, 4, 1,6 };
        System.out.println(MaxRepeating.findMaxRepeatingElemrnt(arr));
}
    
}
