public class BreadthFirstDirectedPaths {
    private static final int INFINITY = Integer.MAX_VALUE;
    private boolean[] marked;  
    private int[] edgeTo;  
    private int[] distTo; 
    public BreadthFirstDirectedPaths(Digraph G, int s) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
        bfs(G, s);
    }
    public BreadthFirstDirectedPaths(Digraph G, Iterable<Integer> sources) {
        marked = new boolean[G.V()];
        distTo = new int[G.V()];
        edgeTo = new int[G.V()];
        for (int v = 0; v < G.V(); v++) distTo[v] = INFINITY;
        bfs(G, sources);
    }

    // BFS from single source
    private void bfs(Digraph G, int s) {
        Queue<Integer> q = new Queue<>();
        marked[s] = true;
        distTo[s] = 0;
        q.enqueue(s);
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    // BFS from multiple sources
    private void bfs(Digraph G, Iterable<Integer> sources) {
        Queue<Integer> q = new Queue<>();
        for (int s : sources) {
            marked[s] = true;
            distTo[s] = 0;
            q.enqueue(s);
        }
        while (!q.isEmpty()) {
            int v = q.dequeue();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    distTo[w] = distTo[v] + 1;
                    marked[w] = true;
                    q.enqueue(w);
                }
            }
        }
    }

    // length of shortest path from s (or sources) to v
    public int distTo(int v) {
        return distTo[v];
    }

    // is there a directed path from s (or sources) to v?
    public boolean hasPathTo(int v) {
        return marked[v];
    }

    // shortest path from s (or sources) to v; null if no such path
    public Iterable<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<>();
        int x;
        for (x = v; distTo[x] != 0; x = edgeTo[x])
            path.push(x);
        path.push(x);
        return path;
    }
}