class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList());
        }

        int n = prerequisites.length;
        for(int i=0;i<n;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for(int i=0;i<numCourses;i++){
            if(!vis[i]){
                if(isCycle(adj,vis,pathVis,i)) return false;
            }
        }
        return true;
    }

    public boolean isCycle(List<List<Integer>> adj, boolean[] vis, boolean[] pathVis, int node){
        vis[node] = true;
        pathVis[node] = true;
        for(int t : adj.get(node)){
            if(!vis[t]){
                if(isCycle(adj,vis,pathVis,t)) return true;
            }
            else if(pathVis[t]){
                return true;
            }
        }
        pathVis[node] = false;
        return false;
    }
}