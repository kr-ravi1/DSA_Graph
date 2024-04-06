class Solution
{
    //Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid)
    {
        // Code here
        Queue<Pair> q = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        int[][] ans = new int[n][m];
        
        for(int i=0;i<n;i++){
            Arrays.fill(ans[i],-1);
        }
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j] == 1){
                    ans[i][j] = 0;
                    q.add(new Pair(i,j));
                }
            }
        }
            
        while(!q.isEmpty()){
            int[] delr = {-1,0,1,0};
            int[] delc = {0,1,0,-1};
            int r = q.peek().r;
            int c = q.peek().c;
            q.remove();
            for(int i=0;i<4;i++){
                int nr = r+delr[i];
                int nc = c+delc[i];
                if(nr>=0 && nr<n && nc>=0 && nc<m && ans[nr][nc] == -1){
                    ans[nr][nc] = ans[r][c] + 1;
                    q.add(new Pair(nr,nc));
                }
            }
        }
        return ans;
    }
}

class Pair {
    int r;
    int c;
    Pair(int r, int c){
        this.r = r;
        this.c = c;
    }
}