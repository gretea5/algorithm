class Solution {
    public int solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                //오른쪽 하단이 0이면 할 필요가 없음, 인접한 정사각형의 길이중에 가장 작은 길이
                if (board[i][j] > 0) {
                    board[i][j] = Math.min(board[i - 1][j - 1], Math.min(board[i - 1][j], board[i][j - 1])) + 1;
                }
            }
        }
        
        //오른쪽 하단의 최대 정사각형의 길이
        int max = Integer.MIN_VALUE;
        
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                max = Math.max(board[i][j], max);
            }
        }
        
        //넓이 리턴
        return max * max;
    }
}
