class Solution {
    static int numProvinces(ArrayList<ArrayList<Integer>> adj, int V) {
        // code here
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        // conversion of adjacency matrix to adjacency list
        
        for(int i=0;i<V;i++){
            list.add(new ArrayList());
        }
        for(int i=0;i<V;i++){
            for(int j=0;j<V;j++){
                if(i!=j && adj.get(i).get(j) == 1){
                    list.get(i).add(j);
                    list.get(j).add(i);
                }
            }
        }
        
        boolean[] vis = new boolean[V];
        int count = 0;
        for(int i=0;i<V;i++){
            if(!vis[i]){
                count++;
                dfs(list,vis,i);
            }
        }
        return count;
    }
    
    public static void dfs(ArrayList<ArrayList<Integer>> list,boolean[] vis, int node){
        Queue<Integer> q = new LinkedList<>();
        q.add(node);
        vis[node] = true;
        while(!q.isEmpty()){
            int temp = q.poll();
            for(int t : list.get(temp)){
                if(!vis[t]){
                    q.add(t);
                    vis[t] = true;
                }
            }
        }
        return;
    }
};
