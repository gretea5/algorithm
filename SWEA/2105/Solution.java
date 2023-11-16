import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[][] board;
    private static int N;
    private static int answer, startX, startY;
    //사각형의 모양에 알맞게 방향 배열을 지정
    private static int[] dx = {1, 1, -1, -1};
    private static int[] dy = {1, -1, -1, 1};
    private static boolean[] eat;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            N = Integer.parseInt(br.readLine());
            board = new int[N][N];
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                //2차원 배열 입력
                for(int j = 0; j < N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            answer = -1;
            for(int i = 0; i < N; i++) {
                for(int j = 1; j < N - 1; j++) {
                    //먹는 처리 배열 생성
                    eat = new boolean[101];
                    eat[board[i][j]] = true;

                    startX = i;
                    startY = j;

                    dfs(i, j, -1, -1, 0, 0);
                }
            }
            sb.append("#").append(test).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private static void dfs(int x, int y, int beforeX, int beforeY, int distance, int direction) {
        for(int curDir = direction; curDir < 4; curDir++) {
            int mx = x + dx[curDir];
            int my = y + dy[curDir];

            //범위를 빠져나갔거나, 이전 정점으로 가려고할 경우 막는다.
            if(isNotRange(mx, my)) continue;
            if(beforeX == mx && beforeY == my) continue;
            //인접 정점에 시작점이 있을 경우,
            if(mx == startX && my == startY && distance > 2) {
                answer = Math.max(answer, distance + 1);
                return;
            }
            //가려고하는 디저트가 먹은 디저트 일경우,
            if(eat[board[mx][my]]) continue;
            //먹는 처리
            eat[board[mx][my]] = true;
            //먹었다고 했을때 경로 계산
            dfs(mx, my, x, y, distance + 1, curDir);
            //다시 안먹는 처리
            eat[board[mx][my]] = false;
        }
    }
    private static boolean isNotRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}
