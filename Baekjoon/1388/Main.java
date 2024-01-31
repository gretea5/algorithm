import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;

    private static boolean[][] visited;
    private static char[][] board;

    private static int[] dx1 = {0, 0};
    private static int[] dy1 = {1, -1};

    private static int[] dx2 = {1, -1};
    private static int[] dy2 = {0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        board = new char[N][M];

        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        int answer = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(visited[i][j]) continue;

                if(board[i][j] == '-') dfs1(i, j);
                else if(board[i][j] == '|') dfs2(i, j);

                answer += 1;
            }
        }

        System.out.print(answer);

        br.close();
    }

    private static void dfs1(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 2; i++) {
            int mx = x + dx1[i];
            int my = y + dy1[i];

            if(mx < 0 || mx >= N || my < 0 || my >= M) continue;

            if(!visited[mx][my] && board[mx][my] == '-') {
                dfs1(mx, my);
            }
        }
    }

    private static void dfs2(int x, int y) {
        visited[x][y] = true;

        for(int i = 0; i < 2; i++) {
            int mx = x + dx2[i];
            int my = y + dy2[i];

            if(mx < 0 || mx >= N || my < 0 || my >= M) continue;

            if(!visited[mx][my] && board[mx][my] == '|') {
                dfs2(mx, my);
            }
        }
    }
}
