import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    private static class Point {
        int x;
        int y;
        int distance;
        Point(int x, int y, int distance) {
            this.x = x;
            this.y = y;
            this.distance = distance;
        }
    }

    private static int targetX;
    private static int targetY;
    private static int N;

    private static int[] dx = {-2, -2, 0, 0, 2, 2};
    private static int[] dy = {-1, 1, -2, 2, -1, 1};

    private static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //시작과 목표지점 입력
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        targetX = Integer.parseInt(st.nextToken());
        targetY = Integer.parseInt(st.nextToken());

        //방문 배열 선언
        visited = new boolean[N][N];

        //bfs 호출
        System.out.print(bfs(startX, startY));

        br.close();
    }

    private static int bfs(int startX, int startY) {
        //큐 선언
        ArrayDeque<Point> queue = new ArrayDeque<>();

        //방문 처리 및 큐에 시작점 정보 넣기
        visited[startX][startY] = true;
        queue.addLast(new Point(startX, startY, 0));

        while(!queue.isEmpty()) {
            //현재 점 꺼내기
            Point cur = queue.removeFirst();

            //목표점에 도달 했을 경우
            if(cur.x == targetX && cur.y == targetY) return cur.distance;

            for(int i = 0; i < 6; i++) {
                //점 이동
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];

                //체스판 밖으로 벗어났을 경우,
                if(mx < 0 || my < 0 || mx >= N || my >= N) continue;

                //방문처리 되지 않았을때, 이동 가능한 경우
                if(!visited[mx][my]) {
                    //방문 처리후 큐에 정보 넣기
                    visited[mx][my] = true;
                    queue.addLast(new Point(mx, my, cur.distance + 1));
                }
            }
        }

        //모든 연산을 했음에도 리턴되지 않을 경우, -1리턴
        return -1;
    }
}
