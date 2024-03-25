class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        Queue<Integer> q = new LinkedList<>();
        boolean vis[] = new boolean[V];
        ArrayList<Integer> list = new ArrayList<>();
        q.add(0);
        vis[0] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            list.add(temp);
            for(int t : adj.get(temp)){
                if(!vis[t]) {
                    q.add(t);
                    vis[t] = true;
                }
            }
        }
        return list;
    }
}