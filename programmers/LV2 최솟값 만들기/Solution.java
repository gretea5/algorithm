import java.util.Arrays;

class Solution {
    public int solution(int []A, int []B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int length = A.length;
        int answer = 0;

        for(int i = 0; i < length; i++) {
            answer += (A[i] * B[length - 1 - i]);
        }

        return answer;
    }
}
