class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int[][] mat = new int[26][26];
        for(int i=0;i<26;i++) {
            Arrays.fill(mat[i], Integer.MAX_VALUE);
            mat[i][i] = 0;
        }

        for(int i=0;i<cost.length;i++) {
            mat[original[i]-'a'][changed[i]-'a'] = Math.min(cost[i],  mat[original[i]-'a'][changed[i]-'a']);
        }

        for(int via=0;via<26;via++) {
            for(int i=0;i<26;i++) {
                for(int j=0;j<26;j++) {
                    if(mat[i][via] == Integer.MAX_VALUE || mat[via][j] == Integer.MAX_VALUE) continue;
                    mat[i][j] = Math.min(mat[i][j], mat[i][via]+mat[via][j]);
                }
            }
        }

        long ans = 0;
        for(int i=0;i<source.length();i++) {
            if(mat[source.charAt(i)-'a'][target.charAt(i)-'a'] == Integer.MAX_VALUE) {
                return -1L;
            }
            else {
                ans += mat[source.charAt(i)-'a'][target.charAt(i)-'a'];
            }
        }

        return ans;
    }
}