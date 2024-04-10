class Solution
{
    //Function to return list containing vertices in Topological order. 
    static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) 
    {
        // add your code here
        Queue<Integer> q = new LinkedList<>();
        int[] inDegree = new int[V];
        for(int i=0;i<V;i++){
            for(int it : adj.get(i)){
                inDegree[it]++;
            }
        }
        
        for(int i=0;i<V;i++){
            if(inDegree[i] == 0) q.add(i);
        }
        
        int[] ans = new int[V];
        int i=0;
        while(!q.isEmpty()){
            int temp = q.poll();
            ans[i++] = temp;
            for(int t : adj.get(temp)){
                inDegree[t]--;
                if(inDegree[t] == 0) q.add(t);
            }
        }
        return ans;
    }
}