class Solution {
    public String solution(int n) {
        String[] arr = {"4", "1", "2"};
        String answer = "";
        
        while(n > 0) {
            answer = arr[n % 3] + answer;
            n = (n - 1) / 3;
        }
        
        return answer;
    }
}
