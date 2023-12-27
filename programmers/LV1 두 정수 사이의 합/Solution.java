class Solution {
    public long solution(int a, int b) {
        long start = Math.min(a, b);
        long end = Math.max(a, b);
        long answer = 0;
        for(long i = start; i <= end; i++) {
            answer += i;
        }
        return answer;
    }
}
