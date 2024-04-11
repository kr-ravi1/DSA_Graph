class Solution {
    public boolean isPossible(int N,int P, int[][] prerequisites)
    {
        // Your Code goes here
        // https://bit.ly/3ApDfOm
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<N;i++){
            adj.add(new ArrayList());
        }
        
        for(int i=0;i<P;i++){
            adj.get(prerequisites[i][1]).add(prerequisites[i][0]);
        }
        
        int[] inDegree = new int[N];
        for(int i=0;i<P;i++){
            inDegree[prerequisites[i][0]]++;
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<N;i++){
            if(inDegree[i] == 0) q.add(i);
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            int temp = q.poll();
            list.add(temp);
            for(int t : adj.get(temp)){
                inDegree[t]--;
                if(inDegree[t] == 0) q.add(t);
            }
        }
        return list.size() == N;
    }
    
}
