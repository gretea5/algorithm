import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    /*
    이 문제에서 제일 중요했던건 내부의 공기를 어떻게 처리하는가이다.
    근데 인접한 가장자리는 구멍이 존재한다.
    인접한 부분만 bfs처리를 해서 치즈를 녹여가는 방식을 채택하는것이다.
    근데 치즈를 만나서 그것도 방문처리를 해야함? 안하면? 겹치는 문제가 생길 수 있음
     */
    private static class Air {
        int x;
        int y;

        Air(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int N, M;
    private static int meltCnt;

    private static boolean[][] visited;
    private static int[][] board;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N][M];
        board = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;

        while (!isAllMelted()) {
            //다음시간에서 녹인 여부를 기록하는 배열을 갱신
            visited = new boolean[N][M];

            //녹인 개수 초기화
            meltCnt = 0;

            //bfs를 수행해서 인접한 치즈를 녹인다.
            bfs();

            //시간 증가
            hour += 1;
        }

        System.out.println(hour);
        System.out.print(meltCnt);

        br.close();
    }

    private static void bfs() {
        ArrayDeque<Air> queue = new ArrayDeque<>();

        queue.addLast(new Air(0, 0));
        visited[0][0] = true;

        while(!queue.isEmpty()) {
            Air cur = queue.removeFirst();

            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                if(mx < 0 || mx >= N || my < 0 || my >= M) continue;

                if(!visited[mx][my]) {
                    if(board[mx][my] == 0) {
                        queue.addLast(new Air(mx, my));
                    }
                    //즉 치즈일 경우 녹여서 공기가 되었는지 아니면 그냥 공기였는지 구분을 못한다.
                    //그래서 치즈인 경우에도 방문처리를 해줘야 올바른 치즈의 개수를 구할 수 있다.
                    else {
                        board[mx][my] = 0;
                        meltCnt += 1;
                    }
                    visited[mx][my] = true;
                }
            }
        }
    }

    private static boolean isAllMelted() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(board[i][j] == 1) return false;
            }
        }

        return true;
    }
}
