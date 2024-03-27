class Solution
{
    //Function to find minimum time required to rot all oranges. 
    public int orangesRotting(int[][] grid)
    {
        // Code here
        int tm = 0;
        int m = grid.length;
        int n = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean vis[][] = new boolean[m][n];
        int delr[] = {0,1,0,-1};
        int delc[] = {-1,0,1,0};
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j,0));
                }
            }
        }
        
        while(!q.isEmpty()){
            int r = q.peek().x;
            int c = q.peek().y;
            int t = q.peek().time;
            tm = Math.max(tm,t);
            q.remove();
            for(int i=0;i<4;i++){
                int newr = r+delr[i];
                int newc = c+delc[i];
                if(newr >= 0 && newr<m && newc >= 0 && newc<n && !vis[newr][newc] && grid[newr][newc] == 1){
                    grid[newr][newc] = 2;
                    q.add(new Pair(newr,newc,t+1));
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        
        return tm;
    }
}

class Pair{
    int x;
    int y;
    int time;
    Pair(int x,int y,int time){
        this.x = x;
        this.y = y;
        this.time = time;
    }
}
