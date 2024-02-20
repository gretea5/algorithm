import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int R, C;
    private static int oCnt, vCnt;

    private static boolean[][] visited;
    private static char[][] board;

    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //R, C 입력
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        //배열 초기화
        visited = new boolean[R][C];
        board = new char[R][C];

        //마당 값들 입력
        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        //살아 남은 늑대수, 양의 수
        int oSum = 0;
        int vSum = 0;

        //살아 남은 늑대, 양의 수를 dfs를 이용해 구한다.
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                if(!visited[i][j] && board[i][j] != '#') {
                    //다른 영역이므로, 영역에 있는 양의수와 늑대의 수를 초기화
                    oCnt = 0;
                    vCnt = 0;
                    dfs(i, j);
                    if(oCnt > vCnt) oSum += oCnt;
                    else vSum += vCnt;
                }
            }
        }

        //출력
        System.out.print(oSum + " " + vSum);

        br.close();
    }

    private static void dfs(int x, int y) {
        //방문처리
        visited[x][y] = true;

        //현재 늑대일 경우, 양일 경우
        if(board[x][y] == 'o') oCnt += 1;
        else if(board[x][y] == 'v') vCnt += 1;

        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if(mx < 0 || mx >= R || my < 0 || my >= C) continue;

            //인접해 있다면,
            if(!visited[mx][my] && board[mx][my] != '#') {
                dfs(mx, my);
            }
        }
    }

}
