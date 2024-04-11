class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        // code here
        int[] inDegree = new int[V];
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<V;i++){
            for(int t : adj.get(i)){
                inDegree[t]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0) q.add(i);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int temp = q.poll();
            list.add(temp);
            for(int t : adj.get(temp)){
                inDegree[t]--;
                if(inDegree[t] == 0) q.add(t);
            }
        }
        
        return list.size()!=V;
    }
}