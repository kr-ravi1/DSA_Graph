class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {
        // Your code here
        List<Integer> list = new ArrayList<>();
        boolean[] vis = new boolean[V];
        boolean[] path = new boolean[V];
        boolean[] check = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj,vis,path,check,i);
            }
        }
        for(int i=0;i<V;i++){
            if(check[i]){
                list.add(i);
            }
        }
        return list;
    }
    
    boolean dfs(List<List<Integer>> adj, boolean[] vis, boolean[] path, boolean[] check, int node){
        vis[node] = true;
        path[node] = true;
        check[node] = false;
        for(int t : adj.get(node)){
            if(!vis[t]) {
                if(dfs(adj,vis,path,check,t)) return true;
            }
            else if(path[t]){
                return true;
            }
        }
        path[node] = false;
        check[node] = true;
        return false;
    }
}