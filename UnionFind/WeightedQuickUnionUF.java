package UnionFind;
public class WeightedQuickUnionUF {
    private int[] id;
    private int[] size;
    private int count;
    public WeightedQuickUnionUF(int N){
        id=new int[N];
        size=new int[N];
        count=N;
        for(int i=0;i<N;i++)
        {
            id[i]=i;
            size[i]=i;
        }
    }
    private int root(int i){
        while(i!=id[i])
        {
            id[i]=id[id[i]];
            i=id[i];
        }
        return i;
    }
    public boolean isConnected(int p,int q){
        return root(p)==root(q);
    }
    public void union(int p,int q){
        int pid=root(p);
        int qid=root(q);
        if(pid==qid)return;
        if(size[pid]<size[qid]){
            id[pid]=qid;
            size[qid]=size[qid]+size[pid];
        }
        else{
            id[qid]=pid;
            size[pid]=size[pid]+size[qid];
        }
        count--;
    }
    public int count(){
        return count;
    }
    
    
}
