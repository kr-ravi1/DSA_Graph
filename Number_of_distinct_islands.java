class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<ArrayList<Integer>>> set = new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<ArrayList<Integer>> list = new ArrayList<>();
                    dfs(grid,i,j,vis,list,i,j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }
    
    void dfs(int[][] grid, int r, int c,boolean[][] vis, ArrayList<ArrayList<Integer>> list,int base_x, int base_y){
        ArrayList<Integer> l = new ArrayList<>();
        l.add(r-base_x);
        l.add(c-base_y);
        list.add(new ArrayList(l));
        vis[r][c] = true;
        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1};
        int n = grid.length;
        int m = grid[0].length;
        for(int i=0;i<4;i++){
            int nr = r+delr[i];
            int nc = c+delc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && grid[nr][nc] == 1){
                dfs(grid,nr,nc,vis,list,base_x,base_y);
            }
        }
    }
}
