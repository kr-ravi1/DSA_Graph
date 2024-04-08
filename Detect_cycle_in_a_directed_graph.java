class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]) {
                if(dfs(adj,i,vis,path)) return true;
            }
        }
        return false;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int node, boolean[] vis, boolean[] path){
        vis[node] = true;
        path[node] = true;
        
        for(int t : adj.get(node)){
            if(!vis[t]){
                if(dfs(adj,t,vis,path)) return true;
            }
            else if(path[t]){
                return true;
            }
        }
        path[node] = false;
        return false;
    }
}
