class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        int[] delc = {0, 1, 0, -1};
        int[] delr = {-1, 0, 1, 0};
        Queue<Pair> q = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 2) q.add(new Pair(i, j));
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            count++;
            for(int i=0;i<size;i++) {
                int x = q.peek().x;
                int y = q.peek().y;
                q.poll();
                for(int j=0;j<4;j++) {
                    int nr = x + delr[j];
                    int nc = y + delc[j];
                    if(nr >= 0 && nr < n && nc >= 0 && nc < m && grid[nr][nc] == 1) {
                        q.add(new Pair(nr, nc));
                        grid[nr][nc] = 2;
                    }
                }
            }
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if(grid[i][j] == 1) return -1;
            }
        }

        return count == 0 ? count : count - 1; // for the testcase which only contains 0
    }
}

class Pair {
    int x;
    int y;
    public Pair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}