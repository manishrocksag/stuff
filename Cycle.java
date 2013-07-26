public class Cycle {
    private boolean[] marked;
    private int[] edgeTo;
    private Stack<Integer> s;
    public Cycle(Graph G){
        if(hasSelfLoops(G))
            return;
        if(hasParallelEdges(G))
            return;
        marked=new boolean[G.V()];
        edgeTo=new int[G.V()];
        for(int v=0;v<G.V();v++)
            if(!marked[v])
                dfs(G,v,v); 
    }
    public boolean hasCycle(Graph G){
        return (!s.isEmpty());  
    }
    public Iterable<Integer> cycle(){
        return s; 
    }
    private boolean hasSelfLoops(Graph G){
        for(int v=0;v<G.V();v++)
            for(int w:G.adj(v))
                if(v==w){
                    s=new Stack<>();
                    s.push(v);
                    s.push(v);
                    return true;
                }
        return false;  
    }
    private boolean hasParallelEdges(Graph G){
        marked=new boolean[G.V()];
        for(int v=0;v<G.V();v++){
            for(int w:G.adj(v)){
                if(marked[w]){
                    s=new Stack<>();
                    s.push(v);
                    s.push(w);
                    s.push(v);
                    return true;
                }
            marked[w]=true;}
        for(int w:G.adj(v))
            marked[w]=false;
        }
        return false;
        
    }
    private void dfs(Graph G,int u,int v){
        marked[v]=true;
        for(int w:G.adj(v)){
            if(!s.isEmpty())
                return;
            if(!marked[w]){
                edgeTo[w]=v;
                dfs(G,v,w);
            }
            else if(w!=u){
                s=new Stack<>();
                for(int x=v;x!=w;x=edgeTo[x])
                    s.push(x);
                s.push(w);
                s.push(v);
            }          
        }
    }
}