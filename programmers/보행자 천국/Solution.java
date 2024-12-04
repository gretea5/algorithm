class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        //0이면, 오른쪽에 온 방향, 1이면 위쪽에서 온 방향
        //dp[i][j][k] = (i - 1, j - 1)에서 k의 방향으로 뻗어나가는 전체 경로의 수
        
        //dp 배열 만들기
        int[][][] dp = new int[m + 1][n + 1][2];
        
        //시작점은 1
        dp[1][1][0] = 1;
        dp[1][1][1] = 1;
        
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int point = cityMap[i - 1][j - 1];
                
                //현재 정점이 0이라면 오른쪽, 밑으로 경우의 수가 뻗어 나감
                if (point == 0) {
                    dp[i][j][0] += (dp[i][j - 1][0] + dp[i - 1][j][1]) % MOD;
                    dp[i][j][1] += (dp[i][j - 1][0] + dp[i - 1][j][1]) % MOD;
                }
                else if (point == 1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                }
                //2라면 오던 방향으로 가야함
                else {
                    dp[i][j][0] = dp[i][j - 1][0];
                    dp[i][j][1] = dp[i - 1][j][1];
                }
            }
        }
        
        return dp[m][n][0];
    }
}
