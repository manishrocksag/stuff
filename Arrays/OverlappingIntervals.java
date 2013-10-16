public class OverlappingIntervals {  
     private  boolean less(Comparable v,Comparable w){
            return v.compareTo(w) < 0;
        }
        private void swap(Comparable[] a,int i,int j){
            Comparable v=a[i];
            a[i]=a[j];
            a[j]=v;   
        }
       private boolean isSorted(Comparable[] a){
            for(int i=1;i<a.length;i++)
                if(less(a[i],a[i-1]))
                    return false;
            return true;
        }
        private void sort(Comparable[] a ){
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
        public void mergeInterval(Interval[] arr){
            if(arr.length<=0)
                return;
            Stack<Interval> s=new Stack<>();
            sort(arr);
            s.push(arr[0]);
            for(int i=1;i<arr.length;i++){
                Interval top=s.top();
        // if current interval is not overlapping with stack top,
        // push it to the stack
                if(top.endTime < arr[i].startTime){
                    s.push(arr[i]);
                }
                // Otherwise update the ending time of top if ending of current 
        // interval is more
                else if(top.endTime <arr[i].endTime){
                    top.endTime=arr[i].endTime;
                    s.pop();
                    s.push(top);
                } 
            }
            while(!s.isEmpty()){
                Interval x=(s.pop());   
                System.out.printf("start time is %d and end time is %d",x.startTime,x.endTime);
                System.out.println("");
                
            }
        } 
        public static void main(String[] args) {
            Interval[] arr=new Interval[4];
            arr[0]=new Interval(6,8);
            arr[1]=new Interval(1,3);
            arr[2]=new Interval(2,4);
            arr[3]=new Interval(4,7);
            OverlappingIntervals obj=new OverlappingIntervals();
            obj.mergeInterval(arr);
            
}
    
}
    

