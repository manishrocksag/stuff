public class DepthFirstOrder{
    private boolean[] marked;
    private Stack<Integer> reversePost;
    public DepthFirstOrder(Digraph G){
        marked=new boolean[G.V()];
        reversePost=new Stack<>();
        for(int v=0;v<G.V();v++)
            if(!marked[v])
                dfs(G,v);
    }
    private void dfs(Digraph G,int s){
        marked[s]=true;
        for(int w:G.adj(s))
            if(!marked[w])
                dfs(G,w);
        reversePost.push(s);
        
    }
    public Iterable<Integer> reversePost(){
        return reversePost;
    }
}