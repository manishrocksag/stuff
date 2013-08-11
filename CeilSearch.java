/**
 *
 * Ceiling of x:Smallest element greater than or equal to x
 */
public class CeilSearch {
    public int ceilIndex(int[] arr,int low,int high,int x){
        if(arr[low]>=x)
            return low;
        if(arr[high]<x)
            return -1;
        int mid=low+(high-low)/2;
        if(arr[mid]==x)
            return mid;
        if(x>arr[mid]){
            if(mid+1<=high&&arr[mid+1]>=x)
                return mid+1;
            else
               return ceilIndex(arr, mid+1, high, x);
        }
        if(mid-1>=low&&x>arr[mid-1])
            return mid;
        else
           return ceilIndex(arr, low, mid-1, x);
    }
    public static void main(String[] args) {
        CeilSearch obj=new CeilSearch();
        int[] arr={1,6,9,11,14};
        System.out.println(obj.ceilIndex(arr, 0, arr.length-1, 10));
    }
    
}
