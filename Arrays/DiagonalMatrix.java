public class DiagonalMatrix {
    
    private static int max(int a,int b){
        return a > b?a:b;
    }
    private static int min(int a,int b){
        return a<b?a:b;
    }
    private static int min(int a,int b,int c){
        return min(min(a,b),c);
    }
    public static void printMatrixDiagonally(int[][] mat){
        int ROW=mat.length;
        int COL=mat[0].length;
        
        for(int line=0;line<=ROW+COL-1;line++){
            int start_col_no=max(0,line-ROW);
            int count=min(line,COL-start_col_no,ROW);
            for(int j=0;j<count;j++){
                System.out.printf("%5d",mat[min(ROW,line)-j-1][start_col_no+j]);
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
    int M[][] = {{1, 2, 3, 4},
                       {5, 6, 7, 8},
                       {9, 10, 11, 12},
                       {13, 14, 15, 16},
                       {17, 18, 19, 20},
                      };
    DiagonalMatrix.printMatrixDiagonally(M);
}
    
}
