public class StringInterleaving {
    public static boolean check(String a,String b,String c){
        int i=0,j=0,k=0;
        while(c.charAt(i)!='M' ){
            if(b.charAt(j)==c.charAt(i)&&!b.isEmpty())
                System.out.println(++j);
            else if(a.charAt(k)==c.charAt(i)&&!a.isEmpty())
                System.out.println(++k);
            else
                return false;
            System.out.println(++i);
        }
        if(a.charAt(k)!='0' ||b.charAt(j)!='0')
            return false;
        return true;
    }
    public static int isInterleaved(String a,String b,String c){
        int M=a.length();
        int N=b.length();
        int[][] IL;
        IL=new int[M][N];
        if(M+N!=c.length())
            return 0;
        for(int i=0;i<=M;i++){
            for(int j=0;j<=N;j++){
                if(i==0&&j==0)
                    IL[i][j]=0;
                else if (i==0 && b.charAt(j-1)==c.charAt(j-1) )
                    IL[i][j] = IL[i][j-1];
                else if (j==0 && a.charAt(i-1) ==c.charAt(i-1))
                    IL[i][j] = IL[i-1][j];
                else if(a.charAt(i-1) ==c.charAt(i+j-1) && b.charAt(j-1) !=c.charAt(i+j-1))
                    IL[i][j] = IL[i-1][j];
                else if (a.charAt(i-1) !=c.charAt(i+j-1) &&b.charAt(j-1) ==c.charAt(i+j-1))
                    IL[i][j] = IL[i][j-1];
                else if (a.charAt(i-1) ==c.charAt(i+j-1) &&b.charAt(j-1) ==c.charAt(i+j-1))
                    IL[i][j]=(IL[i-1][j]) ;
        }
    }
 
    return IL[M][N];
  }  
  public static void main(String[] args) {
        System.out.println(StringInterleaving.isInterleaved("AB", "CD", "ABCD"));
        //String x="aabcd";
        //System.out.println(x.charAt(0));
   
        }   
}
