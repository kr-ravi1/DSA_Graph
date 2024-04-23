class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList());
        } 

        int[] indegree = new int[n];
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
            indegree[edges[i][0]]++;
            indegree[edges[i][1]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i] == 1){
                q.add(i);
                indegree[i]--;
            }
        }

        List<Integer> ans = new ArrayList<>();
        ans.add(0);
        while(!q.isEmpty()){
            ans.clear();
            int size = q.size();
            for(int i=0;i<size;i++){
                int node = q.poll();
                ans.add(node);
                for(int t : adj.get(node)){
                    indegree[t]--;
                    if(indegree[t] == 1) q.add(t);
                }
            }
        }
        return ans;
    }
}