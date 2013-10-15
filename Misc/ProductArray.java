/* 
 * A Product Array prod[] (of same size) such that prod[i] is equal to the
 * product of all the elements of arr[] except arr[i]
 */
public class ProductArray {
    public void solveProductArray(int[] arr){
        int len=arr.length;
        int[] left=new int[len];
        int[] right=new int[len];
        left[0]=1;
        right[len-1]=1;
        for(int i=1;i<len;i++)
            left[i]=arr[i-1]*left[i-1];
        for(int j=len-2;j>=0;j--)
            right[j]=right[j+1]*arr[j+1];
        for(int i=0;i<len;i++)
            arr[i]=left[i]*right[i];   
         for(int i=0;i<len;i++)
             System.out.println(arr[i]);
    }
    public static void main(String[] args) {
        ProductArray obj=new ProductArray();
        int []arr= {10, 3, 5, 6, 2};
        obj.solveProductArray(arr);

    }
   
    
    
}
