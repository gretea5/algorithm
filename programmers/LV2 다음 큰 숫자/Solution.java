class Solution {
    public int solution(int n) {
        int count = Integer.bitCount(n);
        int answer;
        while(true) {
            n += 1;
            if(count == Integer.bitCount(n)) {
                answer = n;
                break;
            }
        }
        return answer;
    }
}
