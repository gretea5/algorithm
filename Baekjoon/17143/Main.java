import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static class Shark {
        int x;
        int y;
        int speed;
        int dir;
        int size;
        
        Shark(int x, int y, int speed, int dir, int size) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.dir = dir;
            this.size = size;
        }
    }
    
    private static int r;
    private static int c;
    
    private static Shark[][] sea;
    
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, 1, 0, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System .in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        
        int m = Integer.parseInt(st.nextToken());
        
        sea = new Shark[r][c];
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            int speed = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());
            int size = Integer.parseInt(st.nextToken());
            
            //위
            if (dir == 1) {
                dir = 0;
            }
            //아래
            else if (dir == 2) {
                dir = 2;
            }
            //오른쪽,
            else if (dir == 3) {
                dir = 1;
            }
            //왼쪽
            else {
                dir = 3;
            }
            
            sea[x][y] = new Shark(x, y, speed, dir, size);
        }
        
        int location = -1;
        int answer = 0;
        
        while(true) {
            //낚시왕의 이동
            location += 1;
            
            if (location == c) {
                break;
            }
            
            //제일 가까운 상어를 잡는다.
            for(int i = 0; i < r; i++) {
                if (sea[i][location] != null) {
                    //잡은 크기 더함
                    answer += sea[i][location].size;
                    
                    //상어 제거
                    sea[i][location] = null;
                    
                    break;
                }
            }
            
            //큐에 상어 정보를 넣어둔다.
            ArrayDeque<Shark> queue = new ArrayDeque<>();
            
            for(int i = 0; i < r; i++) {
                for(int j = 0; j < c; j++) {
                    if (sea[i][j] != null) {
                        queue.addLast(sea[i][j]);
                    }
                }
            }
            
            //바다를 다시 갱신(상어가 겹치지 않기 위해)
            sea = new Shark[r][c];
            
            while(!queue.isEmpty()) {
                Shark s = queue.removeFirst();
                
                int x = s.x;
                int y = s.y;
                int speed = s.speed;
                int dir = s.dir;
                int size = s.size;
                
                //포인트 speed 줄이는거, 
                if (dir == 0 || dir == 2) {
                    speed %= (r - 1) * 2;
                }
                else {
                    speed %= (c - 1) * 2;
                }
                
                while(speed > 0) {
                    int mx = x + dx[dir];
                    int my = y + dy[dir];
                    
                    if (mx < 0 || mx >= r || my < 0 || my >= c) {
                        dir = (dir + 2) % 4;
                        
                        mx = x + dx[dir];
                        my = y + dy[dir];
                    }
                    
                    x = mx;
                    y = my;
                    
                    speed -= 1;
                }
                
                //상어가 있을 경우,
                if (sea[x][y] != null) {
                    //크기가 더 크다면 => 넣어준다.
                    if (sea[x][y].size < size) {
                        sea[x][y] = new Shark(x, y, s.speed, dir, size);
                    }
                }
                //상어가 없다면 그냥 넣는다.(dir, spped 주의)
                else {
                    sea[x][y] = new Shark(x, y, s.speed, dir, size);
                }
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
