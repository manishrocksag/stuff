public class CircularTour {
    public static class PetrolPump{
         int petrol;
         int dis;
        public PetrolPump(int petrol,int dis){
            this.petrol=petrol;
            this.dis=dis;
        }
    }   
    public int findCircularTour(PetrolPump[] arr,int n){
        int start=0;
        int end=1;
        int currPetrol=arr[start].petrol-arr[start].dis;
        while(start!=end || currPetrol<0  ){
            while(currPetrol <0 && start!=end ){
                currPetrol-=arr[start].petrol-arr[start].dis;
                start=(start+1)%n;
                if(start==0)
                    return -1;
            }
            currPetrol+=arr[end].petrol-arr[end].dis;
            end=(end+1)%n;
        }
        return start;
    }
    public static void main(String[] args) {
    PetrolPump[] arr=new PetrolPump[4];
    arr[0]=new PetrolPump(4,6);
    arr[1]=new PetrolPump(6,5);
    arr[2]=new PetrolPump(7,3);
    arr[3]=new PetrolPump(4,5);
    CircularTour obj=new CircularTour();
        System.out.println(obj.findCircularTour(arr, arr.length));
    
}
    
}
