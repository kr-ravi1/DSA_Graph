class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(dfs(adj,vis,i,-1)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis,int node,int parent){
        vis[node] = true;
            for(int t : adj.get(node)){
                if(!vis[t]){
                    if(dfs(adj,vis,t,node)) return true;
                }
                else if(t != parent) return true;
            }
        return false;
    }
}
