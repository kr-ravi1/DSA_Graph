class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!vis[i][j] && grid[i][j] == '1') {
                    count++;
                    dfs(grid,vis,i,j);
                }
            }
        }
        return count;
    }
    
    public void dfs(char[][] grid,boolean[][] vis, int r,int c){
        int m = grid.length;
        int n = grid[0].length;
        int[] delr = {-1,-1,-1,0,1,1,1,0};
        int[] delc = {-1,0,1,1,1,0,-1,-1};
        vis[r][c] = true;
        for(int i=0;i<8;i++){
            int nr = r+delr[i];
            int nc = c+delc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && grid[nr][nc] == '1' && !vis[nr][nc]){
                dfs(grid,vis,nr,nc);
            }
        }
        return;
    }
}
