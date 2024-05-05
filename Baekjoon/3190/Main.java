import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;
import java.util.Objects;

public class Main {
    private static class Command {
        int time;
        String dir;
        
        Command(int time, String dir) {
            this.time = time;
            this.dir = dir;
        }
    }
    
    private static class Pos {
        int x;
        int y;
    
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
        
        @Override
        public boolean equals(Object o) {
            Pos p = (Pos) o;
            
            return this.x == p.x && this.y == p.y;
        }
        
        @Override
        public int hashCode() {
            return Objects.hash(this.x, this.y);
        }
    }
    
    private static int n;
    private static int k;
    private static int l;
    
    private static boolean[][] isApple;
    
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        
        isApple = new boolean[n + 1][n + 1];
        
        for(int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            isApple[x][y] = true;
        }
        
        l = Integer.parseInt(br.readLine());
        
        ArrayDeque<Command> cq = new ArrayDeque<>();
        
        for(int i = 0; i < l; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int time = Integer.parseInt(st.nextToken());
            String dir = st.nextToken();
            
            cq.addLast(new Command(time, dir));
        }
        
        ArrayList<Pos> snake = new ArrayList<>();
        
        int time = 1;
        
        int direction = 3;
        
        snake.add(new Pos(1, 1));
        
        while(true) {
            //몸길이를 늘려서 머리를 다음 칸에 위치 시킴
            Pos head = snake.get(0);
            
            int headX = head.x + dx[direction];
            int headY = head.y + dy[direction];
            
            snake.add(0, new Pos(headX, headY));
            
            if (checkGame(snake)) {
                break;
            }
            
            if (isApple[headX][headY]) {
                isApple[headX][headY] = false;
            }
            else {
                snake.remove(snake.size() - 1);
            }
            
            if (!cq.isEmpty()) {
                if (cq.peekFirst().time == time) {
                    Command c = cq.removeFirst();
                
                    String dir = c.dir;
                    
                    //오른쪽으로 90도 회전(시계 방향)
                    if (dir.equals("D")) {
                        direction -= 1;
                        
                        if (direction < 0) {
                            direction = 3;
                        }
                    }
                    //왼쪽으로 90도 회전(반시계 방향)
                    else {
                        direction = (direction + 1) % 4;
                    }
                }
            }
            
            //시간 늘리기
            time += 1;
        }
        
        System.out.print(time);
        
        br.close();
    }
    
    private static boolean checkGame(ArrayList<Pos> snake) {
        HashSet<Pos> set = new HashSet<>();
        
        for(Pos s : snake) {
            if (s.x == 0 || s.x >= n + 1 || s.y == 0 || s.y >= n + 1) {
                return true; 
            }
            
            set.add(s);
        }
        
        if (snake.size() != set.size()) {
            return true;
        }
        
        return false;
    }
}
