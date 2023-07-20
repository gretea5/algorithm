class Solution {
    public int[] solution(long n) {
        String str = String.valueOf(n);
        StringBuilder sb = new StringBuilder(str);
        sb = sb.reverse();
        str = sb.toString();
        int[] answer = new int[str.length()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = (int)(str.charAt(i) - '0');
        }
        return answer;
    }
}
