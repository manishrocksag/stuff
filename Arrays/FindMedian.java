public class FindMedian {
    public static int getMedian(int[] arr1,int[] arr2,int n ){
        int i=0;
        int j=0;
        int count;
        int m1=-1,m2=-1;
        for(count=0;count<=n;count++){
            if(i==n){
                m1=m2;
                m2=arr2[0];
                break;
            }
            if(j==n){
                m1=m2;
                m2=arr1[0];
                break;
            }
            if(arr1[i]<arr2[j]){
                m1=m2;
                m2=arr1[i];
                i++;
            }
            else{
                m1=m2;
                m2=arr2[j];
                j++;
            }
        }
        return (m1+m2)/2;
    }
   public static int getMedian(int[] arr1,int[] arr2,int left,int right,int n){
        int i,j;
        if(left>right)
            return getMedian(arr2,arr1,0,n-1,n);
        i=(left+right)/2;
        j=n-i-1;
        if((arr1[i]>arr2[j]||j==0) && (j==n-1||arr1[i]<=arr2[j+1])){
           // if(i==0||arr2[j]>arr1[i-1])
                return (arr1[i]+arr2[j])/2;
            //else
              //  return (arr1[i]+arr2[i-1])/2;
        }
        else if(arr1[i]>arr2[j]&&j!=n-1&&arr1[i]>arr2[j+1])
            return getMedian(arr1,arr2,left,i-1,n);
        else
            return getMedian(arr1,arr2,i+1,right,n);
        
    }
   public static int getMedianDifferentLengths(int[] arr1,int[] arr2,int n1,int n2){
       int size=(n1+n2)/2;
       int i=0;
       int j=0;
       int elementsToinspect=size/2;
       if(elementsToinspect ==0)
           return arr1[i];
       while(true){
           if (arr1[i] < arr2[i]) {
        i++;
        elementsToinspect--;
        if(elementsToinspect == 0)
            return arr1[i];
    } else {
        j++;
        elementsToinspect--;
        if (elementsToinspect == 0)
            return arr2[j];
    }
           
       }
   }
    public static void main(String[] args) {
     // int  ar1[] = {1, 5, 7, 10, 13};
 //int  ar2[] = {11, 15, 23, 30, 45};
        int ar1[] = {1, 12, 15, 26, 38,40};
    int ar2[] = {2, 13, 17, 30, 45,48,50,52,54,58,60};
   // System.out.print(FindMedian.getMedian(ar1, ar2,0,ar1.length-1, ar1.length));
    System.out.print(FindMedian.getMedianDifferentLengths(ar1, ar2,ar1.length, ar2.length));
}
}
