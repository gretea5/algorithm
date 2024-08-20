import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static boolean isFinish;

    private static int[][] ansBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String s = br.readLine();

            for (int j = 0; j < 9; j++) {
                board[i][j] = s.charAt(j) - '0';
            }
        }

        isFinish = false;

        ansBoard = new int[9][9];

        backTrack(board, 0);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                sb.append(ansBoard[i][j]);
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void backTrack(int[][] board, int idx) {
        //배열에 값이 기록이 되었다면, return
        if (isFinish) {
            return;
        }

        if (idx == 81) {
            //배열을 복사
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    ansBoard[i][j] = board[i][j];
                }
            }

            //배열에 값이 기록되었음을 표시
            isFinish = true;

            return;
        }

        int row = idx / 9;
        int col = idx % 9;

        if (board[row][col] != 0) {
            backTrack(board, idx + 1);
        }
        else {
            for (int i = 1; i <= 9; i++) {
                if (check(board, row, col, i)) {
                    board[row][col] = i;

                    backTrack(board, idx + 1);

                    board[row][col] = 0;
                }
            }
        }
    }

    private static boolean check(int[][] board, int x, int y, int value) {
        //행중에 자기 자신을 제외하고 value가 있을 경우
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == value) {
                return false;
            }

            if (board[i][y] == value) {
                return false;
            }
        }

        int sx = (x / 3) * 3;
        int sy = (y / 3) * 3;

        for (int i = sx; i < sx + 3; i++) {
            for (int j = sy; j < sy + 3; j++) {
                if (board[i][j] == value) {
                    return false;
                }
            }
        }

        return true;
    }
}
