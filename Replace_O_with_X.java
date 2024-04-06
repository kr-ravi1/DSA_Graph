class Solution{
    static char[][] fill(int n, int m, char a[][])
    {
        // code here
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<m;i++){
            if(a[0][i] == 'O' && !vis[0][i]) dfs(a,0,i,vis);
            if(a[n-1][i] == 'O' && !vis[n-1][i]) dfs(a,n-1,i,vis);
        }
        for(int i=0;i<n;i++){
            if(a[i][0] == 'O' && !vis[i][0]) dfs(a,i,0,vis);
            if(a[i][m-1] == 'O' && !vis[i][m-1]) dfs(a,i,m-1,vis);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && a[i][j] == 'O') a[i][j] = 'X';
            }
        }
        return a;
    }
    
    static void dfs(char[][] a, int r, int c,boolean[][] vis){
        vis[r][c] = true;
        int n = a.length;
        int m = a[0].length;
        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr = r+delr[i];
            int nc = c+delc[i];
            if(nr>=0 && nr<n && nc>=0 && nc<m && !vis[nr][nc] && a[nr][nc] == 'O'){
                dfs(a,nr,nc,vis);
            }
        }
        return;
    }
}
