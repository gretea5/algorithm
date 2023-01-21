import java.util.ArrayDeque;

class Solution {
    public int[][] solution(int[][] rc, String[] operations) {
        ArrayDeque<Integer> left = new ArrayDeque<>();
        ArrayDeque<Integer> right = new ArrayDeque<>();
        ArrayDeque<ArrayDeque<Integer>> mid = new ArrayDeque<>();
        int h = rc.length;
        int w = rc[0].length;
        //배열에 있는 값을 덱에 넣는 방법
        for(int i = 0; i < h; i++) {
            left.offerLast(rc[i][0]);
            ArrayDeque<Integer> m = new ArrayDeque<>();
            for(int j = 1; j < w - 1; j++) {
                m.offerLast(rc[i][j]);
            }
            right.offerLast(rc[i][w - 1]);
            mid.offerLast(m);
        }
        for(String s : operations) {
            if(s.equals("Rotate")) {
                mid.peekFirst().offerFirst(left.pollFirst());
                right.offerFirst(mid.peekFirst().pollLast());
                mid.peekLast().offerLast(right.pollLast());
                left.offerLast(mid.peekLast().pollFirst());
            }
            else {
                left.offerFirst(left.pollLast());
                mid.offerFirst(mid.pollLast());
                right.offerFirst(right.pollLast());
            }
        }
        int[][] answer = new int[h][w];
        for(int i = 0; i < h; i++) {
            answer[i][0] = left.pollFirst();
            ArrayDeque<Integer> m = mid.pollFirst();
            for(int j = 1; j < w - 1; j++) {
                answer[i][j] = m.pollFirst();
            }
            answer[i][w - 1] = right.pollFirst();
        }
        return answer;
    }
}
