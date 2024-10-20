import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;

public class Main {
    private static class Pos {
        int x, y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n, m;
    private static int answer;
    private static int[][] board;

    private static boolean[] checked;
    private static ArrayList<Pos> virusPosList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][n];
        virusPosList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                //바이러스를 둘 수 있는 위치
                if (board[i][j] == 2) {
                    //바이러스의 위치를 모두 기록
                    virusPosList.add(new Pos(i, j));
               
                }
            }
        }

        checked = new boolean[virusPosList.size()];

        answer = Integer.MAX_VALUE;

        backTrack(0, 0);

        if (answer == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }

        System.out.print(answer);

        br.close();
    }

    private static void backTrack(int idx, int depth) {
        //내가 depth 만큼 즉 m개를 골랐다면,
        if (depth == m) {
            //바이러스를 퍼트려 봄.
            answer = Math.min(bfs(), answer);

            return;
        }

        for (int i = idx; i < virusPosList.size(); i++) {
            if (!checked[i]) {
                checked[i] = true;

                backTrack(i + 1, depth + 1);

                checked[i] = false;
            }
        }
    }

    private static int bfs() {
        final int[] dx = {1, -1, 0, 0};
        final int[] dy = {0, 0, 1, -1};

        boolean[][] visited = new boolean[n][n];
        int[][] dist = new int[n][n];

        ArrayDeque<Pos> queue = new ArrayDeque<>();

        //선택된 바이러스에 대해서 위치와 거리를 0을 처리한다.
        for (int i = 0; i < checked.length; i++) {
            if (checked[i]) {
                int x = virusPosList.get(i).x;
                int y = virusPosList.get(i).y;

                //바이러스의 위치를 큐에 넣는다.
                queue.addLast(new Pos(x, y));
                visited[x][y] = true;
                dist[x][y] = 0;
            }
        }

        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();

            int x = cur.x;
            int y = cur.y;

            for (int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx < 0 || mx >= n || my < 0 || my >= n) continue;

                if (!visited[mx][my] && board[mx][my] != 1) {
                    queue.addLast(new Pos(mx, my));
                    visited[mx][my] = true;
                    dist[mx][my] = dist[x][y] + 1;
                }
            }
        }

        int max = 0;

        // 빈 칸이 모두 바이러스에 감염되었는지 확인
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 빈 칸인데 방문하지 않았다면, 바이러스를 퍼뜨릴 수 없음
                if (board[i][j] == 0 && !visited[i][j]) {
                    return Integer.MAX_VALUE;
                }
                
                if (board[i][j] == 2 && !visited[i][j]) {
                    return Integer.MAX_VALUE;
                }

                // 최대 시간을 구함 (벽인 경우 제외)
                if (board[i][j] != 1 && visited[i][j]) {
                    max = Math.max(max, dist[i][j]);
                }
            }
        }


        return max;
    }
}
