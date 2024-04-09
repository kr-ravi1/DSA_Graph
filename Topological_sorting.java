class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        boolean[] vis = new boolean[V];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<V;i++){
            if(!vis[i]){
                dfs(adj,vis,i,s);
            }
        }
        int[] ans = new int[V];
        for(int i=0;i<V;i++){
            ans[i] = s.pop();
        }
        return ans;
    }
    
    static void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int node, Stack<Integer> s){
        vis[node] = true;
        for(int t : adj.get(node)){
            if(!vis[t]){
                dfs(adj,vis,t,s);
            }
        }
        s.push(node);
        return;
    }
}
