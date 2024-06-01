class Solution{
    public List<Integer> shortestPath(int n, int m, int edges[][]){
        //  Code Here.
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<m;i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }
        
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        int[] dist = new int[n+1];
        int[] parent = new int[n+1];
        for(int i=0;i<=n;i++){
            dist[i] = Integer.MAX_VALUE;
            parent[i] = i;
        }
        
        dist[1] = 0;
        pq.add(new Pair(1, 0));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int nodeDist = pq.peek().dist;
            pq.remove();
            for(Pair t : adj.get(node)){
                int adjNode = t.node;
                int edg = t.dist;
                if(nodeDist + edg < dist[adjNode]){
                    dist[adjNode] = nodeDist + edg;
                    parent[adjNode] = node;
                    pq.add(new Pair(adjNode, dist[adjNode]));
                }
            }
        }
        List<Integer> path = new ArrayList<>();
        if(dist[n] == Integer.MAX_VALUE){
            path.add(-1);
            return path;
        }
        
        int node = n;
        while(parent[node] != node){
            path.add(0,node);
            node = parent[node];
        }
        path.add(0,node);
        path.add(0,dist[n]);
        return path;
    }
}

class Pair{
    int node;
    int dist;
    Pair(int n, int d){
        node = n;
        dist = d;
    }
}
