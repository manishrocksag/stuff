public class PancakeSorting {
    void flip(int[] arr,int i){
        int start=0,temp;
        while(start<i){
            temp=arr[i];
            arr[i]=arr[start];
            arr[start]=temp;
            start++;
            i--;
        }
    }
    int findMax(int[] arr,int n){
        int maxIndex=0;
        int max=0;
        for(int i=0;i<n;i++){
            if(arr[i]>max){
                max=arr[i];
                maxIndex=i;
            }      
        }
        return maxIndex;
    }
    void sort(int[] arr,int n){
        for(int curr_size=n;curr_size>1;curr_size--){
            int mi=findMax(arr, curr_size);
            if(mi!=curr_size-1){
                flip(arr,mi);
                flip(arr,curr_size-1);
            }
        }
        System.out.println("Sorted Elements");
        System.out.println("");
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    int ceilSearch(int[] arr,int x,int low,int high){
        if(arr[low]>=x)
            return low;
        if(arr[high]<x)
            return -1;
        int mid=low + (high-low)/2;
        if(arr[mid]==x)
            return mid;
        else if(x > arr[mid]){
            if(mid+1<=high && arr[mid+1]>=x)
                return mid+1;
            else
                return ceilSearch(arr, x,mid+1,high);
        }
        else{
            if(mid-1>=low && arr[mid-1]<x)
                return mid;
            else
                return ceilSearch(arr, x, low, mid-1);
        }
        
    }
    public int floorSearch(int[] arr,int x,int low,int high){
        if(arr[low]>x)
            return -1;
        if(arr[high]<=x)
            return high;
        int mid=low + (high-low)/2;
        if(arr[mid]==x)
            return mid;
        if(arr[mid]<x){
            if(arr[mid+1]>=x && mid+1 < high)
                return mid+1;
            else
                return floorSearch(arr, x, mid+1, high);
        }
        else{
            if(arr[mid-1]<x && mid-1>low)
                return mid;
            else
                return floorSearch(arr, x,low, mid-1);
        }
        
    }
    int floorSearchA(int a[], int low, int high, int x)
{
    if(low > high){
        return low;
    }
    int mid = (low+high)/2;
    if(a[mid]>x){
        return floorSearchA(a, low, mid-1, x);
    }
    else if(a[mid]<x){
        return floorSearchA(a, mid+1, high, x);
    }
    else{
        return mid;
    }
}
    public static void main(String[] args) {
    int[] arr={1, 3, 7, 11, 12, 16, 27};
    PancakeSorting obj=new PancakeSorting();
    //obj.sort(arr, arr.length);
        System.out.println(obj.floorSearch(arr,4,0, arr.length-1));
}
}
    

