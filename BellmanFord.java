class Solution {
    static int[] bellman_ford(int V, ArrayList<ArrayList<Integer>> edges, int S) {
        // Write your code here
        int n = edges.size();
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = (int)(1e8);
        }
        dist[S] = 0;
        
        for(int i=0;i<V-1;i++){
            for(ArrayList<Integer> t : edges){
                //relaxation
                int u = t.get(0);
                int v = t.get(1);
                int wt = t.get(2);
                if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v]){
                    dist[v] = dist[u] + wt;
                }
            }
        }
        
        // To check -ve cycle
        for(ArrayList<Integer> t : edges){
            //relaxation
            int u = t.get(0);
            int v = t.get(1);
            int wt = t.get(2);
            if(dist[u] != (int)(1e8) && dist[u] + wt < dist[v]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
            
        return dist;
    }
}
