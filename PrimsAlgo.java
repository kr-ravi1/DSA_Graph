class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.dist - b.dist);
        boolean[] vis = new boolean[V];
        
        int sum = 0;
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            int node = pq.peek().node;
            int nodeDist = pq.peek().dist;
            pq.remove();
            
            if(!vis[node]) {
                vis[node] = true;
                sum += nodeDist;
                for(int i=0;i<adj.get(node).size();i++){
                    int[] temp = adj.get(node).get(i);
                    int adjNode = temp[0];
                    int edg = temp[1];
                    if(!vis[adjNode]){
                        pq.add(new Pair(adjNode, edg));
                    }
                }
            }
        }
        return sum;
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
