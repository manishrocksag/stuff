public class Interval implements Comparable<Interval>{
        public int startTime;
        public int endTime;
        public Interval(int startTime,int endTime){
            this.startTime=startTime;
            this.endTime=endTime;   
        }
        @Override
        public int compareTo(Interval o) {
            if(this.startTime < o.startTime)
                return -1;
            if(this.startTime > o.startTime)
                return 1;
            else
                return 0;
        }
        private static boolean less(Comparable v,Comparable w){
            return v.compareTo(w) < 0;
        }
        private static void swap(Comparable[] a,int i,int j){
            Comparable v=a[i];
            a[i]=a[j];
            a[j]=v;   
        }
       private static boolean isSorted(Comparable[] a){
            for(int i=1;i<a.length;i++)
                if(less(a[i],a[i-1]))
                    return false;
            return true;
        }
        public static void sort(Comparable[] a ){
            int length=a.length;
            for(int i=0;i<length;i++){
                for(int j=i;j>0;j--){
                    if(less(a[j],a[j-1])){
                        swap(a,j,j-1);
                    }
                    else
                        break;
                }
            }
        }
     public static void main(String[] args) {
            Interval[] arr=new Interval[4];
            arr[0]=new Interval(6,8);
            arr[1]=new Interval(1,3);
            arr[2]=new Interval(2,4);
            arr[3]=new Interval(4,7);
            Interval.sort(arr);
            for(int i=0;i<arr.length;i++)
                System.out.println(arr[i].startTime);
            
}
       
}