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
            for(int j=0;j<n;j++){
                //relaxation
                if(dist[edges.get(j).get(0)] != (int)(1e8) && dist[edges.get(j).get(0)] + edges.get(j).get(2) < dist[edges.get(j).get(1)]){
                    dist[edges.get(j).get(1)] = dist[edges.get(j).get(0)] + edges.get(j).get(2);
                }
            }
        }
        
        // To check -ve cycle
        for(int j=0;j<n;j++){
            // Nth relaxation
            if(dist[edges.get(j).get(0)] != (int)(1e8) && dist[edges.get(j).get(0)] + edges.get(j).get(2) < dist[edges.get(j).get(1)]){
                int[] temp = new int[1];
                temp[0] = -1;
                return temp;
            }
        }
            
        return dist;
    }
}
