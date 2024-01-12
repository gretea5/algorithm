
class Solution {
    public static int[] solution(int n, long left, long right) {
        //길이 만큼 배열 선언
        int[] answer = new int[(int) (right - left + 1)];

        //행과 열을 구해서 + 1해서 더 큰값이 해당하는 값
        for(long i = left; i <= right; i++) {
            int row = (int) (i / n);
            int col = (int) (i % n);
            answer[(int) (i - left)] = Math.max(row, col) + 1;
        }

        return answer;
    }
}
