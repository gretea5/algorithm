import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static class Pos {
        int x; 
        int y;
        int dist;
        
        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
    
    private static int n;
    private static int sx;
    private static int sy;
    private static int sSize;
    private static int sCnt;
    
    private static int[][] map;
    private static boolean[][] visited;
    
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
    private static ArrayList<Pos> nearList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                
                if (map[i][j] == 9) {
                    sx = i;
                    sy = j;
                    sSize= 2;
                    sCnt = 0;
                }
            }
        }
        
        int answer = 0;
        
        while(true) {
            nearList = new ArrayList<>();
            
            bfs(sx, sy);
            
            if (nearList.size() == 0) {
                break;
            }
            
            Collections.sort(nearList, (p1, p2) -> { 
                if (p1.dist == p2.dist) {
                    if (p1.x == p2.x) {
                        return p1.y - p2.y;
                    }
                    return p1.x - p2.x;
                }
                return p1.dist - p2.dist; 
            });
            
            Pos nearInfo = nearList.get(0);
            
            int nearX = nearInfo.x;
            int nearY = nearInfo.y;
            int dist = nearInfo.dist;
            
            //원래 상어가 있었던 곳 0 처리
            map[sx][sy] = 0;
            
            //상어가 이동했어,
            sx = nearX;
            sy = nearY;
            
            //물고기 먹어
            sCnt += 1;
            
            //상어의 이동을 기록
            map[sx][sy] = 9;
            
            //크기가 커져야 한다면,
            if (sCnt == sSize) {
                sSize += 1;
                sCnt = 0;
            }
            
            answer += dist;
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void bfs(int x, int y) {
        visited = new boolean[n][n];
        
        ArrayDeque<Pos> queue = new ArrayDeque<>();
        
        queue.addLast(new Pos(x, y, 0));
        visited[x][y] = true;
        
        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();
            
            for(int i = 0; i < 4; i++) {
                int mx = cur.x + dx[i];
                int my = cur.y + dy[i];
                
                if (mx < 0 || mx >= n || my < 0 || my >= n) {
                    continue;
                }
                
                if (!visited[mx][my] && map[mx][my] == sSize) {
                    queue.addLast(new Pos(mx, my, cur.dist + 1));
                    visited[mx][my] = true;
                }
                else if (!visited[mx][my] && 0 < map[mx][my] && map[mx][my] < sSize) {
                    queue.addLast(new Pos(mx, my, cur.dist + 1));
                    visited[mx][my] = true;
                    nearList.add(new Pos(mx, my, cur.dist + 1));
                }
                else if (!visited[mx][my] && map[mx][my] == 0) {
                    queue.addLast(new Pos(mx, my, cur.dist + 1));
                    visited[mx][my] = true;
                }
            }
        }
    }
}
