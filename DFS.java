class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here 
        boolean vis[] = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        helper(adj,list,vis,0);
        return list;
    }
    
    public void helper(ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list, boolean vis[],int temp){
        list.add(temp);
        vis[temp] = true;
        
        for(int t : adj.get(temp)){
            if(!vis[t]){
                helper(adj,list,vis,t);
            }
        }
    }
}
