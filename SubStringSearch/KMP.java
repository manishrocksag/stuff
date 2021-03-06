public class KMP {
    private static final int R=256;
    private String pat;
    private int M;
    private int[][] dfa;
    public KMP(String pat){
        this.pat=pat;
        M=pat.length();
        dfa=new int[R][M];
        dfa[pat.charAt(0)][0]=1;
        for(int X=0,j=1;j<M;j++){
            for(int c=0;c<R;c++)
                dfa[c][j]=dfa[c][X];
            dfa[pat.charAt(j)][j]=j+1;
            X=dfa[pat.charAt(j)][X];
            
        }   
    }  
    public int search(String txt){
        int N=txt.length();
        int i,j;
        for(i=0,j=0;i<N&&j<M;i++)
            j=dfa[txt.charAt(i)][j];
        if(j==M)
            return i-M;
        else
            return N;   
    }
    public static void main(String[] args) {
    KMP obj=new KMP("dog");
        System.out.println(obj.search("he is jim and he is a dog and jim is cool"));
}
}
