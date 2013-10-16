public class BuySell {
    
    private static class Stock{
        int buy;
        int sell;
    }
    public static void findPos(int[] arr){
        int n=arr.length;
        Stock[] st=new Stock[n/2+1];
        for(int x=0;x<st.length;x++)
            st[x]=new Stock();
        int count=0;
    int i=0;
        System.out.println(i);
    while(i<n-1){
        while((i<n-1 )&& (arr[i+1]<=arr[i])){
                i++;
                System.out.println();
        }
        if(i==n-1)
            break;
        //System.out.println(i);
        st[count].buy=i;
        i++;
        while((i<n)&&(arr[i]>=arr[i-1]))
            i++;
        st[count].sell=i-1;
        //System.out.println("it is"+i);
        count++;
    } 
    if(count==0)
            System.out.println("No buying and selling");
    else{
            for(int l=0;l<count;l++)
               System.out.printf("Bought at %d and sold at %d",st[l].buy,st[l].sell);
    }
  }
   public static void main(String[] args) {
        int price[] = {100, 180, 260, 310, 40, 535, 695};
        BuySell.findPos(price);
   
}
}
