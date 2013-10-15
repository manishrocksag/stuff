public class LongestCommonSubstring {
   static int[][] lcs;
    public static int lcs(String x,String y){
        int m=x.length();
        int n=y.length();
        int result =0;
        lcs=new int[m+1][n+1];
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0||j==0)
                    lcs[i][j]=0;
                else if(x.charAt(i-1) ==y.charAt(j-1)){
                    lcs[i][j]=1+lcs[i-1][j-1];
                    result=max(result,lcs[i][j]);                
                }
                else
                    lcs[i][j]=0;
                
            }
        }
        return result;
    }
    public static void printTable(){
        for(int i=0;i<lcs.length;i++){
            for(int j=0;j<lcs[0].length;j++){
                System.out.printf("%3d",lcs[i][j]);
            }
            System.out.println();
                
        }
    }
    private static int max(int a,int b){
        return a>b?a:b;
    }
    public static void main(String[] args) {
        String x="OGeeks";
        String y="GeeksQu";
        System.out.println(LongestCommonSubstring.lcs(x, y));
        LongestCommonSubstring.printTable();
}
    
}
