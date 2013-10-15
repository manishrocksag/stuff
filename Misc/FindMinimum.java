/* Find minimum in a sorted rotated array */
public class FindMinimum {
    public int findMin(int[] arr,int low,int high){
        if(low>high)
            return arr[0];
        if(low==high)
            return arr[low];
        int mid=low+(high-low)/2;
        if(high>mid&&arr[mid]>arr[mid+1])
            return arr[mid+1];
        if(mid>low&&arr[mid-1]>arr[mid])
            return arr[mid];
        if(arr[high]>=arr[mid])
            return findMin(arr,low,mid-1);
        return findMin(arr,mid+1,high);
    }
     public int findMinWithDuplicates(int[] arr,int low,int high){
        if(low>high)
            return arr[0];
        if(low==high)
            return arr[low];
        int mid=low+(high-low)/2;
        if(high>mid&&arr[mid]>arr[mid+1])
            return arr[mid+1];
        if(arr[low]==arr[mid]&&arr[mid]==arr[high])
            return min(findMinWithDuplicates(arr, low, mid-1),findMinWithDuplicates(arr, mid+1, high));
        if(mid>low&&arr[mid-1]>arr[mid])
            return arr[mid];
        if(arr[high]>=arr[mid])
            return findMin(arr,low,mid-1);
        return findMin(arr,mid+1,high);
    }
     private int min(int a,int b){
         return (a<b)?a:b;
     }
   
    /* test cases */
    public static void main(String[] args) {
        FindMinimum obj=new FindMinimum();
        int arr1[] =  {5, 6, 1, 2, 3, 4};
        int arr2[] =  {1, 2, 3, 4};
        int arr3[] =  {4,3,2,5};
        int arr4[] =  {3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,3,4};
        System.out.println(obj.findMinWithDuplicates(arr4, 0, arr4.length-1));
        
    }
    
}
