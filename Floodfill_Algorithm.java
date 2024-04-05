class Solution
{
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor)
    {
        // Code here 
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int oldColor = image[sr][sc];
            image[sr][sc] = newColor;
            dfs(image,newColor,sr,sc,vis,oldColor);
        return image;
    }
    
    public void dfs(int[][] image, int newColor, int r, int c, boolean[][] vis, int oldColor) {
        vis[r][c] = true;
        int n = image.length;
        int m = image[0].length;
        int[] delr = {-1,0,1,0};
        int[] delc = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int nr = r+delr[i];
            int nc = c+delc[i];
            if(nr>=0 && nr < n && nc>=0 && nc<m && !vis[nr][nc] && image[nr][nc] == oldColor){
                image[nr][nc] = newColor;
                dfs(image,newColor,nr,nc,vis,oldColor);
            }
        }
        return;
    }
}
