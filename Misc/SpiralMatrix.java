/**
 * Print the elements of the matrix in the spiral form
 * 
 */
public class SpiralMatrix {
    public static void spiralPrint(int[][] mat,int R,int C){
        int startRow=0;
        int startCol=0;
        int endRow=R;
        int endCol=C;
        while(startRow<endRow&&startCol<endCol){
            // print the first row from remaining row
            for(int i=startCol;i<C;i++)
                System.out.println(mat[startRow][i]);
            startRow++;
            // print the last column from the remaining column
            for(int i=startRow;i<endRow;i++)
                System.out.println(mat[i][endCol-1]);
            endCol--;
            //print the last row from remaining row
            if(startRow<endRow){
                for(int i=endCol-1;i>=startCol;i--)
                    System.out.println(mat[endRow-1][i]);
                endRow--;
            }
            // print the first column from remaining column
            if(startCol<endCol){
                for(int i=endRow-1;i>=startRow;i--)
                    System.out.println(mat[i][startCol]);
                startCol++;
            }
            
        }   
    }
    public static void main(String[] args) {
        // test cases
        int[][] mat={{1, 2,  3,  4,  5,  6},{7,  8,  9,  10, 11, 12},{13, 14, 15, 16, 17, 18}};
        SpiralMatrix.spiralPrint(mat, 3, 6);
        
    }
    
}
