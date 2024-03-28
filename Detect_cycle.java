

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean vis[] = new boolean[V];
        for(int i=0;i<V;i++){
            if(!vis[i]){
                if(bfs(adj,vis,i)) return true;
            }
        }
        return false;
    }
    
    public boolean bfs(ArrayList<ArrayList<Integer>> adj, boolean vis[], int node){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(node,-1));
        vis[node] = true;
        while(!q.isEmpty()){
            int currNode = q.peek().curr;
            int parentNode = q.peek().parent;
            q.remove();
            for(int t : adj.get(currNode)){
                if(!vis[t]) {
                    q.add(new Pair(t,currNode));
                    vis[t] = true;
                }
                else if(t != parentNode) return true; // cycle is present.
            }
        }
        return false;
    }
}

class Pair{
    int curr;
    int parent;
    Pair(int curr, int parent){
        this.curr = curr;
        this.parent = parent;
    }
}