class Solution {
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(word.charAt(0) == board[i][j]) {
                    boolean[][] vis = new boolean[n][m];
                    if(dfs(board,word,i,j,1,vis)) return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, String word, int r, int c, int w,boolean[][] vis){
        if(w == word.length()) return true;
        vis[r][c] = true;
        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1};
        int n = board.length;
        int m = board[0].length;
        for(int i=0;i<4;i++){
            int nr = r+delr[i];
            int nc = c+delc[i];
            if(nr<n && nr>=0 && nc<m && nc>=0 && !vis[nr][nc] && word.charAt(w) == board[nr][nc]){
                if(dfs(board,word,nr,nc,w+1,vis)) return true;
            }
        }
        vis[r][c] = false;
        return false;
    }
}
