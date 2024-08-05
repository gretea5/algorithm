import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    private static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static int n;
    private static int m;
    private static int answer;

    private static int[][] map;
    private static int[][] dist;
    private static boolean[][] visited;

    private static boolean[] selected;
    private static ArrayList<Pos> virusList;
    
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][n];

        int virusCnt = 0;

        virusList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());

                if (map[i][j] == 2) {
                    virusCnt += 1;

                    virusList.add(new Pos(i, j));
                }
            }
        }

        selected = new boolean[virusCnt];

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
        //활성화되는 바이러스를 선택했을 경우,
        if (depth == m) {
            //1. 바이러스를 퍼트려본다.
            spreadVirus();
            
            //2. 빈칸이면서 퍼진 최소 시간을 구하면서 갱신
            if (check()) {
                answer = Math.min(answer, calCnt());
            }
            
            return;
        }

        for(int i = idx; i < selected.length; i++) {
            if (!selected[i]) {
                selected[i] = true;

                backTrack(i + 1, depth + 1);
    
                selected[i] = false;
            }
        }
    }

    private static void spreadVirus() {
        visited = new boolean[n][n];
        dist = new int[n][n];

        ArrayDeque<Pos> queue = new ArrayDeque<>();

        for(int i = 0; i < virusList.size(); i++) {
            if (selected[i]) {
                Pos vPos = virusList.get(i);
                
                queue.addLast(vPos);
                
                visited[vPos.x][vPos.y] = true;
                dist[vPos.x][vPos.y] = 0;
            }
        }
        
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            
            int x = cur.x;
            int y = cur.y;
            
            for(int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];
                
                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }
                
                if (!visited[mx][my] && map[mx][my] != 1) {
                    queue.addLast(new Pos(mx, my));
                    visited[mx][my] = true;
                    
                    dist[mx][my] = dist[x][y] + 1;
                }
            }
        }
    }
    
    private static boolean check() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (!visited[i][j] && map[i][j] == 0) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static int calCnt() {
        int cnt = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                if (visited[i][j] && map[i][j] == 0) {
                    cnt = Math.max(cnt, dist[i][j]);
                }
            }
        }
        
        return cnt;
    }
}
