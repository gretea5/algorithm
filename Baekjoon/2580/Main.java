import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static class Blank {
        int x;
        int y;

        Blank(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int[][] board;
    private static int[][] answer;
    private static ArrayList<Blank> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        board = new int[9][9];
        answer = new int[9][9];
        list = new ArrayList<>();

        for(int i = 0; i < 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if(board[i][j] == 0) list.add(new Blank(i, j));
            }
        }

        backTrack(0);

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                sb.append(answer[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void backTrack(int idx) {
        //빈공간이 다 채워졌을 경우,
        if(idx == list.size()) {
            //정답 배열에 옮긴다.
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    answer[i][j] = board[i][j];
                }
            }

            return;
        }

        int x = list.get(idx).x;
        int y = list.get(idx).y;

        for(int j = 1; j <= 9; j++) {
            if(check(x, y, j)) {
                board[x][y] = j;

                backTrack(idx + 1);

                board[x][y] = 0;
            }
        }
    }

    private static boolean check(int x, int y, int n) {
        //사각형 시작점을 초기화
        int startX = 0;
        int startY = 0;

        for(int i = 0; i <= 6; i += 3) {
            for(int j = 0; j <= 6; j += 3) {
                if(i <= x && x <= i + 2 && j <= y && y <= j + 2) {
                    //시작점 지정
                    startX = i;
                    startY = j;
                }
            }
        }

        //시작점에서 2만큼 가로 세로를 검사해서 숫자가 있는지 확인
        for(int i = startX; i <= startX + 2; i++) {
            for(int j = startY; j <= startY + 2; j++) {
                if(board[i][j] == n) return false;
            }
        }

        //세로 가로 검사
        for(int i = 0; i < 9; i++) {
            if(board[x][i] == n) return false;
            if(board[i][y] == n) return false;
        }

        return true;
    }
}
