public class MaxRow {
    
    private static  int find(int[] row,int low,int high){
        if(high>=low){
            int mid=low + (high-low)/2;
            if((mid==0||row[mid-1]==0)&&row[mid]==1)
                return mid;
            if(row[mid]==0)
                return find(row,mid+1,high);
            else
                return find(row,low,mid-1);
        }
        return -1;
    }
    public static int getRowWithMax1(int[][] arr){
        int row=arr.length;
        int col=arr[0].length;
        int max_row_index=0,max=-1;
        int i,index;
        for(i=0;i<row;i++){
            index=find(arr[i],0,col-1);
            if(index!=-1 && col-index>max){
                max=col-index;
                max_row_index=i;
            }
        }
        return max_row_index;
    }
    public static int getRowWithMax2(int[][] arr){
        int row=arr.length;
        int col=arr[0].length;
        int max_row_index=0;
        int i,index;
        int max=col-find(arr[0],0,col-1);
        for(i=1;i<row;i++){
            if(arr[i][col-max-1]==1){
                 index=find(arr[i],0,col-max);
                 if(index!=-1 && col-index>max){
                    max=col-index;
                    max_row_index=i;
                    }
            }
        }
        return max_row_index;
    }
    public static int getRowWithMax3(int[][] arr){
        int row=arr.length;
        int col=arr[0].length;
        int max_row_index=0;
        int i,index;
        index=find(arr[0],0,col-1);
        if(index==-1)
            index=col-1;
        for(i=1;i<row;i++){
                while(index>=0 && arr[i][index]==1)
                {
                    index--;
                    max_row_index=i;
                }
        }
        return max_row_index;
    }
    
    
    public static void main(String[] args) {
    int[][] mat = { {0, 0, 0, 1},
        {0, 1, 1, 1},
        {1, 1, 1, 1},
        {0, 0, 0, 0}
    };
        System.out.println(MaxRow.getRowWithMax3(mat));
 
}
    
}
