public  class Rearrange {
    
    public static void separatePosNeg(int[] arr,int n){
        int i=0;
        int temp;
        for(int j=0;j<n;j++){
            if(arr[j]<0)
            {
                temp=arr[j];
                arr[j]=arr[i];
                arr[i]=temp;
                i++;
            }  
        }
        int pos=i+1;
        int neg=0;
        while(neg<pos &&pos < n-1){
            temp=arr[neg];
            arr[neg]=arr[pos];
            arr[neg]=arr[pos];
            arr[pos]=temp;
            pos+=1;
            neg+=2;
        }
           
           
        for(int k=0;k<n;k++)
            System.out.println(arr[k]);
        
    }
    public static void main(String[] args) {
   int[] arr={-7,-9,7,9,0,-6,-4,45,-90,99,123,78,98,-65};
   Rearrange.separatePosNeg(arr, arr.length);
}
    
}
