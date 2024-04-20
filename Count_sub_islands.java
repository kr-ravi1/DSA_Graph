class Solution {
    boolean flag = true;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int n = grid1.length;
        int m = grid1[0].length;
        int count = 0;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid2[i][j] == 1 && !vis[i][j] && grid1[i][j] == 1){
                    flag = true;
                    if(dfs(grid1,grid2,i,j,vis)) count++;
                }
            }
        }
        return count;
    }

    public boolean dfs(int[][] grid1, int[][] grid2, int r, int c, boolean[][] vis){
        vis[r][c] = true;
        int n = grid1.length;
        int m = grid1[0].length;
        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr = r + delr[i];
            int nc = c + delc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && grid2[nr][nc] == 1 && !vis[nr][nc]) {
                if(grid1[nr][nc] == 0) flag = false;
                dfs(grid1,grid2,nr,nc,vis);
            }
        }
        if(!flag) return false;
        return true;
    }
}
