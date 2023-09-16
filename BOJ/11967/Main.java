import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.ArrayDeque;
public class Main {
    private static class Pos {
        int x;
        int y;
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    private static int N, M;
    private static int[][] map;
    private static boolean[][] visited;
    private static  ArrayList<Pos>[][] graph;
    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {-1, 1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        graph = new ArrayList[N][N];
        //graph 초기화
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                graph[i][j] = new ArrayList<>();
            }
        }
        //스위치 정보 넣기
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            graph[x][y].add(new Pos(a, b));
        }
        //중요한 부분 시작 점은 불이 켜져있음
        map[0][0] = 1;
        System.out.print(bfs(0, 0) + 1);
        br.close();
    }
    private static int bfs(int x, int y) {
        visited = new boolean[N][N];
        int count = 0;
        boolean isSwitchOn = false;
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        queue.addLast(new Pos(x, y));
        visited[x][y] = true;
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            //인접 정접으로 이동하기
            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                if(isNotRange(mx, my)) continue;
                if(!visited[mx][my] && map[mx][my] == 1) {
                    queue.addLast(new Pos(mx, my));
                    visited[mx][my] = true;
                }
            }
            //스위치 켜기
            for(Pos switchOnPos : graph[cur.x][cur.y]) {
                //스위치가 꺼져있다면(안 킨 애들만 센다)
                if(map[switchOnPos.x][switchOnPos.y] == 0) {
                    //켜져 있는 걸로 바꾼다
                    map[switchOnPos.x][switchOnPos.y] = 1;
                    count += 1;
                    isSwitchOn = true;
                }
            }
        }
        //스위치를 한번이라도 켰으면 더해서 축적(안 킨 스위치의 개수만 계속 더한다)
        if(isSwitchOn) {
            return count + bfs(0, 0);
        }
        return count;
    }
    private static boolean isNotRange(int x, int y) {
        return x < 0 || x >= N || y < 0 || y >= N;
    }
}
