public class MaximumPairs {
    public static class pair{
        int a;
        int b;
        pair(int a,int b){
            this.a=a;
            this.b=b;
        }
    }
    public static int findMaxPair(pair[] arr){
        int n=arr.length;
        int[] mcl=new int[n];
        for(int i=0;i<n;i++)
            mcl[i]=1;
        for(int i=1;i<n;i++){
            for(int j=0;j<i;j++){
                if(arr[i].a > arr[j].b && mcl[i]<mcl[j]+1 )
                    mcl[i]=mcl[j]+1;
            }
        }
        int max=0;
        for(int i=0;i<mcl.length;i++){
            System.out.println(mcl[i]);
            if(mcl[i]>max)
                max=mcl[i];
        }
        return max;
        
    }
    public static void main(String[] args) {
    pair[] p=new pair[4];
    p[0]=new pair(5,24);
    p[1]=new pair(15,25);
    p[2]=new pair(27,40);
    p[3]=new pair(50,60);
        System.out.println(MaximumPairs.findMaxPair(p));
}
    
}
