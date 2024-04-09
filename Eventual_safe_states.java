class Solution {
    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        List<Integer> list = new ArrayList<>();
        boolean[] path = new boolean[V];
        for(int i=0;i<V;i++){
            boolean[] vis = new boolean[V];
            if(dfs(adj,vis,path,i)) list.add(i);
        }
        return list;
    }
    
    boolean dfs(List<List<Integer>> adj, boolean[] vis, boolean[] path, int node){
        vis[node] = true;
        path[node] = true;
        for(int t : adj.get(node)){
            if(!vis[t]) {
                if(!dfs(adj,vis,path,t)) return false;
            }
            else if(path[t]){
                return false;
            }
        }
        path[node] = false;
        return true;
    }
}
