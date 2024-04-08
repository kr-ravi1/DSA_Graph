class Solution
{
    public boolean isBipartite(int V, ArrayList<ArrayList<Integer>>adj)
    {
        // Code here
        int[] color = new int[V];
        Arrays.fill(color,-1);
        for(int i=0;i<V;i++){
            if(color[i] == -1){
                if(!dfs(adj,color,i,0)) return false;
            }
        }
        return true;
    }
    
    public boolean dfs(ArrayList<ArrayList<Integer>> adj, int[] color, int node, int col){
        color[node] = col;
        
        for(int t : adj.get(node)){
            if(color[t] == -1){
                if(!dfs(adj,color,t,1-col)) return false;
            }
            else if(color[t] == col){
                return false;
            }
        }
        return true;
    } 
}