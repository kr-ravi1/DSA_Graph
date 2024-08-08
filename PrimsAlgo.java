class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        // Code Here.
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a,b) -> a.wt-b.wt);
        int sum = 0;
        pq.add(new Tuple(0, 0));
        boolean[] vis = new boolean[V];
        
        while(!pq.isEmpty()) {
            Tuple tup = pq.poll();
            if(!vis[tup.node]) {
                vis[tup.node] = true;
                sum += tup.wt;
                for(int[] t : adj.get(tup.node)) {
                    if(!vis[t[0]]) {
                        pq.add(new Tuple(t[1], t[0]));
                    }
                }
            }
        }
        
        return sum;
    }
}

class Tuple {
    int wt;
    int node;
    
    public Tuple(int wt, int node) {
        this.wt = wt;
        this.node = node;
    }
}