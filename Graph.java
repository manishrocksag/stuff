public class Graph
{
	public final int V;
        public int E;
	private Bag<Integer>[] adj;
	public Graph(int V)
        {
                this.V=V;
		adj=(Bag<Integer>[]) new Bag[V];
		for(int i=0;i<V;i++)
			adj[i]=new Bag<>();
	}
	public void addEdge(int v,int w)
	{
                if (v < 0 || v >= V) throw new 										IndexOutOfBoundsException();
                if (w < 0 || w >= V) throw new 										IndexOutOfBoundsException();
                E++;
		adj[v].add(w);
		adj[w].add(v);
	}
      public int V(){
            return V;
        }
      public int E(){
            return E;
        }
	 public Iterable<Integer> adj(int v)
	{
		return adj[v];
	}
    		@Override
     public String toString()
	 {
        StringBuilder s = new StringBuilder();
        String NEWLINE = System.getProperty("line.separator");
        s.append(V).append(" vertices, ").append(E).append(" edges ").append(NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : adj[v]) {
                s.append(w).append(" ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
}