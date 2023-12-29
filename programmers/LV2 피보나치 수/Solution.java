
class Solution {
    private static int LENGTH = 100_001;
    public int solution(int n) {
        int[] dp = new int[LENGTH];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i < LENGTH; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1234567;
        }
        return dp[n];
    }
}
