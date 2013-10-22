public class MinJumps {
    
    public static int minJumps(int[] arr,int low,int high){
        if(high==low)
            return 0;
        if(arr[low]==0)
            return Integer.MAX_VALUE;
        int min=Integer.MAX_VALUE;
        for(int i=low+1;i<=high && i<=low + arr[low];i++){
            System.out.println(" i as "+i+" and  high as "+high);
            int jumps=minJumps(arr, i, high);
            System.out.println("Jumps are "+jumps);
            if(jumps!=Integer.MAX_VALUE && jumps+1<min)
                min=jumps+1;
            
        }
        return min;
    }
    public static void main(String[] args) {
    int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
        System.out.println(MinJumps.minJumps(arr, 0, arr.length-1));
}
    
}
