public class PairWithDifference {
    public static boolean isPair(int[] arr,int x){
        int i=0;int j=1;
        while(i< arr.length && j<arr.length){
            if(i!=j && arr[j]-arr[i]==x)
                return true;
            else if(arr[j]-arr[i]>x)
                i++;
            else
                j++;
        }
        return false;  
    }
    public static void main(String[] args) {
    int arr[] = {1, 8, 30, 40, 100};
        System.out.println(PairWithDifference.isPair(arr, 199));
}
    
}
