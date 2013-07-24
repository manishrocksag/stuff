public class GraphProcessing
{
	public static int degree(Graph G,int v)
	{
		int degree=0;
		for(int w:G.adj(v))
			degree++;
		return degree;
	}
	public static int maxDegree(Graph G)
	{
		int maxDegree=0;
		for(int v=0;v<G.V();v++)
			if(degree(G,v)>max)
				maxDegree=degree(G,v);
		return maxDegree;
	}
	public static double averageDegree(Graph G)
	{
		2.0*G.E()/G.V();
	}
	public static int noOfSelfLoops(Graph G)
	{
		int count=0;
		for(int v=0;v<G.V();v++)
			for(int w:G.adj(v))
				if(v==w)
					count++;
		return count/2;
	}
}
