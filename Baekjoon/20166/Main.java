import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayDeque;
public class Main {
    private static class Point {
        int x;
        int y;
        int length;
        String str;

        Point(int x, int y, int length, String str) {
            this.x = x;
            this.y = y;
            this.length = length;
            this.str = str;
        }
    }
    private static char[][] map;
    private static int MAX_LEN = Integer.MIN_VALUE;
    private static HashMap<String, Integer> strCountMap = new HashMap<>();
    private static int[] dx = {0, 0, -1, 1, 1, -1, 1, -1};
    private static int[] dy = {-1, 1, 0, 0, 1, -1, -1, 1};
    private static int N, M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        String[] likeStr = new String[K];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        for(int i = 0; i < K; i++) {
            String input = br.readLine();
            likeStr[i] = input;
            MAX_LEN = Math.max(MAX_LEN, input.length());
            strCountMap.put(input, 0);
        }
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                bfs(i, j);
            }
        }
        for(String s : likeStr) {
            sb.append(strCountMap.get(s)).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private static void bfs(int x, int y) {
        ArrayDeque<Point> queue = new ArrayDeque<>();
        queue.addLast(new Point(x, y, 1, map[x][y] + ""));
        while(!queue.isEmpty()) {
            Point curPoint = queue.removeFirst();
            if(curPoint.length > MAX_LEN) continue;
            if(strCountMap.containsKey(curPoint.str)) {
                strCountMap.put(curPoint.str, strCountMap.get(curPoint.str) + 1);
            }
            for(int i = 0; i < 8; i++) {
                int moveX = curPoint.x + dx[i];
                int moveY = curPoint.y + dy[i];
                if(moveX >= N) moveX -= N;
                if(moveY >= M) moveY -= M;
                if(moveX < 0) moveX += N;
                if(moveY < 0) moveY += M;
                queue.addLast(new Point(moveX, moveY, curPoint.length + 1, curPoint.str + map[moveX][moveY]));
            }
        }
    }
}
