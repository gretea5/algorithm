class Solution {
    private final int MOD = 1_000_000_007;
    
    public int solution(int n, int[] money) {
        int moneyCnt = money.length;
        
        int[][] dp = new int[moneyCnt + 1][n + 1];
        
        //i번째 화폐로 0원을 만드는 경우의 수, 즉 0원을 만드려면, 아무것도 고르지 않음
        for (int i = 1; i < moneyCnt + 1; i++) {
            dp[i][0] = 1;
        }
        
        //화폐
        for (int i = 1; i < moneyCnt + 1; i++) {
            int m = money[i - 1];
            //가격
            for (int j = 1; j < n + 1; j++) {
                //현재 화폐를 사용하지 사용하지 않는 경우의 수를 가져옴
                dp[i][j] = dp[i - 1][j];
                
                //화폐를 사용할 수 있을 경우
                if (j >= m) {
                    dp[i][j] += dp[i][j - m];
                }
                
                dp[i][j] %= MOD;
            }
        }
        
        return dp[moneyCnt][n];
    }
}
