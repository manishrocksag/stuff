public class GraphColoring { 
    private int[] color;
    private boolean isSafe(Graph G,int v,int c,int[] color){
            for(int w:G.adj(v))
                if(c==color[w])
                    return false;
            return true;
            
    }
    /*
     * Here v is the starting vertex of the Graph.The color is a array which
     * maintains the color assigned to a particular vertex.No 2 vertex shoild
     * be assigned the same color.
     * 
     */
    private boolean graphColoring(Graph G,int noOfColors,int[] color,int v){
        if(v==G.V())
            return true;
        for(int c=1;c<=noOfColors;c++){
            if(isSafe(G,v,c,color)){
                color[v]=c;
                if(graphColoring(G, noOfColors, color, v+1))return true;
            color[v]=0;
            }
        }
        return false;
    }  
    private void printSolution(int[] color){
        for(int i=0;i<color.length;i++)
            System.out.println("Vetex " +i+ "is assigned the color "+color[i]);
    }
    public boolean solve(Graph G,int noOfColors){
        color=new int[G.V()];
        if(graphColoring(G, noOfColors, color,0)){
            printSolution(color);
            return true;
        }
        else{
            System.out.println("Too Few Colors");
            return false;
        }
        
    }
}