public class BreadthFirstPaths
{
	private final static int INFINITY=Integer.MAX_VALUE;
	private boolean[] marked;
	private int[] edgeTo;
	private int[] distTo;
	private final int s;
	public BreadthFirstPaths(Graph G,int s)
	{
		this.s=s;
		marked=new boolean[G.V()];
		edgeTo=new int[G.V()];
		distTo=new int[G.V()];
		for(int v=0;v<G.V();v++)
			distTo[v]=INFINITY;
		bfs(G,s);
	}
	private void bfs(Graph Gint s)
	{
		Queue<Integer> q=new Queue<>();
		q.enqueue(s);,
		distTo[s]=0;
		marked[s]=true;
		while(!q.isEmpty())
		{
			int v=q.dequeue();
			for(int w:G.adj(v))
			{
				if(!marked[w])
				{
					q.enqueue(w);
					marked[w]=true;
					edgeTo[w]=v;
					distTo[w]=distTo[v]+1;
				}
			}
		}
	}
	public boolean hasPathTo(int v)
	{
		return marked[v];
	}
	public int distTo(int v)
	{
		return distTo[v];
	}
	public Iterable<Integer> pathTo(int v)
	{
		if(!marked[v])
			return null;
		Stack<Integer> path=new Stack<>();
		for(int x=v;distTo[v]!=0;x=edgeTo[x])
			path.push(x);
		path.push(v);
		return path;
	}
}

	

