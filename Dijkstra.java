class Solution
{
    //Function to find the shortest distance of all the vertices
    //from the source vertex S.
    static int[] dijkstra(int V, ArrayList<ArrayList<ArrayList<Integer>>> adj, int S)
    {
        // Write your code here
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((a,b) -> a.distance - b.distance);
        
        int[] dist = new int[V];
        for(int i=0;i<V;i++){
            dist[i] = (int)(1e9);
        }
        
        dist[S] = 0;
        pq.add(new Pair(0,S));
        
        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();
            for(int i=0;i<adj.get(node).size();i++){
                int edgeWt = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);
                if(dis + edgeWt < dist[adjNode]){
                    dist[adjNode] = dis + edgeWt;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
        return dist;
    }
}

class Pair{
    int distance;
    int node;
    Pair(int dis, int n) {
        distance = dis;
        node = n;
    }
}
