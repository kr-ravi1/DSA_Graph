class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i=0;i<numCourses;i++){
            adj.add(new ArrayList());
        }
        int n = prerequisites.length;
        for(int i=0;i<n;i++){
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
            inDegree[prerequisites[i][1]]++;
        }
        
        toposort(numCourses, adj, 0, inDegree);
        for(int i=0;i<numCourses;i++){
            if(inDegree[i] > 0) return false;
        }
        return true;
    }

    public void toposort(int n, List<List<Integer>> adj, int node, int[] inDegree){
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++){
            if(inDegree[i] == 0){
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int temp = q.poll();
            for(int t : adj.get(temp)){
                inDegree[t]--;
                if(inDegree[t] == 0) q.add(t);
            }
        }
        return;
    }
}