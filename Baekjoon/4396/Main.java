import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int[] dx = {-1, -1, -1, 0, 0, 1, 1, 1};
    public static int[] dy = {0, 1, -1, 1, -1, 0, 1, -1};
    public static int n;
    public static char[][] finalBoard;
    public static char[][] playingBoard;
    public static boolean mineChecked;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        finalBoard = new char[n][n];
        playingBoard = new char[n][n];
        //초기 지뢰 설정
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                finalBoard[i][j] = input.charAt(j);
            }
        }
        //.인곳은 일단 주변에 위치하는 지뢰의 개수를 센다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (finalBoard[i][j] == '.') {
                    char mineCount = countMineNumber(i, j);
                    finalBoard[i][j] = mineCount;
                }
            }
        }
        //현재 게임 진행중인 판을 입력받는다.
        for(int i = 0; i < n; i++) {
            String input = br.readLine();
            for(int j = 0; j < n; j++) {
                char c = input.charAt(j);
                playingBoard[i][j] = c;
                //즉 x 이면서 *이라는 건 사용자가 지뢰를 클릭했다는 의미
                if (c == 'x' && finalBoard[i][j] == '*') {
                    mineChecked = true;
                }
            }
        }
        //지뢰를 클릭했을 경우,
        if (mineChecked) {
            printContainingMine();
        }
        //지뢰를 클릭하지 않았을 경우,
        else {
            printBoard();
        }
        br.close();
    }

    public static void printContainingMine() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                //지뢰 자리라면
                if (finalBoard[i][j] == '*') {
                    sb.append("*");
                }
                //x이면서 지뢰자리가 아니라면
                else if(playingBoard[i][j] == 'x') {
                    sb.append(finalBoard[i][j]);
                }
                //x가 아니라면
                else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                //x라면
                if(playingBoard[i][j] == 'x') {
                    sb.append(finalBoard[i][j]);
                }
                else {
                    sb.append('.');
                }
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
    public static char countMineNumber(int curX, int curY) {
        int count = 0;
        for(int i = 0; i < 8; i++) {
            int moveX = curX + dx[i];
            int moveY = curY + dy[i];
            if (0 <= moveX && moveX < n && 0 <= moveY && moveY < n && finalBoard[moveX][moveY] == '*') {
                count++;
            }
        }
        char characterCount = (char)(count + '0');
        return characterCount;
    }
}
