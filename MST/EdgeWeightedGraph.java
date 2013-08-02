public class EdgeWeightedGraph {
    private final int V;
    private int E;
    private final Bag<Edge>[] adj;
    public EdgeWeightedGraph(int V){
        this.V=V;
        adj=(Bag<Edge>[])new Bag[V];
        for(int v=0;v<V;v++)
            adj[v]=new Bag<>();       
    }
    public void addEdge(Edge e){
        E++;
        int v=e.either();
        int w=e.other(v);
        adj[v].add(e);
        adj[w].add(e);
    }
    public int E(){
        return E;
    }
    public int V(){
        return V;
    }
    public Iterable<Edge> adj(int v){
        return adj[v];
    }
    
}