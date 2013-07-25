public class ConnectedComponents
{
	private boolean[] marked;
	private int[] id;
	private int[] size;
	private int count;
	public ConnectedComponents(Graph G)
	{
		marked=new boolean[G.V()];
		id=new int[G.V()];
		size=new int[G.V()];
		for(int v=0;v<G.V();v++)
		{
			if(!marked[v])
			{
				dfs(G,v);
				count++;
			}
		}
	}
	private void dfs(Graph G,int s)
	{
		marked[s]=true;
		id[s]=count;
		size[count]++;
		for(int w:G.adj(s))
			if(!marked[w])
				dfs(G,w);
	}
	public int id(int v)
	{
		return id[v];
	}
	public int size(int v)
	{
		return size[id[v]];
	}
	public int count()
	{
		return count;
	}
	public boolean areConnected(int v,int w)
	{
		return id[v]==id[w];
	}
}
		
