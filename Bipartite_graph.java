class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color = new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i] == -1){
                if(!bfs(V,adj,color,i)) return false;
            }
        }
        return true;
    }
    
    public boolean bfs(int V, ArrayList<ArrayList<Integer>>adj, int[] color, int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        color[node] = 0;
        while(!q.isEmpty()){
            int temp = q.peek();
            q.remove();
            for(int t : adj.get(temp)){
                if(color[t] == -1){
                    color[t] = 1 - color[temp];
                    q.add(t);
                }
                else if(color[t] == color[temp]){
                    return false;
                }
            }
        }
        return true;
    }
}
