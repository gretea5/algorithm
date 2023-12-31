class Solution {
    public static int solution(int n) {
        int[] arr = new int[n + 1];

        for(int i = 1; i <= n; i++) {
            arr[i] = i;
        }

        int start = 1;
        int end = 1;
        int count = 0;
        int sum = 0;

        while (start <= n) {
            if (sum < n) {
                sum += arr[end++];
            } else if (sum > n) {
                sum -= arr[start++];
            } else {
                count += 1;
                sum -= arr[start++];
            }
        }

        return count;
    }
}
