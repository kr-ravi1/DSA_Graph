class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // graph
        ArrayList<ArrayList<Pair>> graph = new ArrayList<>();
        for(int i=0;i<26;i++) {
            graph.add(new ArrayList<>());
        }

        for(int i=0;i<original.length;i++) {
            int o = original[i]-'a';
            int c = changed[i]-'a';
            graph.get(o).add(new Pair(c, cost[i]));
        }

        int ans = 0;
        for(int i=0;i<source.length();i++) {
            if(source.charAt(i) != target.charAt(i)) {
                int temp = minCost(graph, source.charAt(i)-'a', target.charAt(i)-'a');
                if(temp == -1) return temp;
                else ans += temp;
            }
        }

        return ans;
    }

    public int minCost(ArrayList<ArrayList<Pair>> graph, int src, int dest) {
        PriorityQueue<Pair> q = new PriorityQueue<>((a,b) -> a.cost-b.cost);
        q.add(new Pair(src, 0));
        int[] dist = new int[26];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        int effCost = Integer.MAX_VALUE;
        while(!q.isEmpty()) {
            Pair p = q.poll();
            for(Pair t : graph.get(p.ch)) {
                int newCost = p.cost+t.cost;
                if(dist[t.ch] > newCost) {
                    dist[t.ch] = newCost;
                    if(t.ch != dest) {
                        q.add(new Pair(t.ch, newCost));
                    }
                }
            }
        }

        effCost = dist[dest];
        return effCost==Integer.MAX_VALUE? -1 : effCost;
    }
}

class Pair {
    int ch;
    int cost;
    public Pair(int ch, int cost) {
        this.ch = ch;
        this.cost = cost;
    }
}
