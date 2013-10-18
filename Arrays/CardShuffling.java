public class CardShuffling {
    public static void randomShuffle(int[] arr){
        int n=arr.length;
        for(int i=0;i<arr.length;i++){
            int random=(int)((Math.random()*i)+1);
            System.out.println("Random number generated is "+random);
            swap(arr,i,random);
        }
        for(int i=0;i<arr.length;i++)
            System.out.println(arr[i]);
    }
    private static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
    }
    public static void main(String[] args) {
    int[] arr=new int[1000000];
    for(int i=0;i<arr.length;i++)
        arr[i]=i;
    CardShuffling.randomShuffle(arr);
}
    
}
