import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer> dirList;
    private static boolean[][] check;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        check = new boolean[101][101];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            
            //입력 받은 세대에 대한 방향을 담을 ArrayList
            dirList = new ArrayList<>();
            
            //방향을 기록하고, 
            recordDirection(d, g);
            
            //움직여서 점에 check 한다.
            move(x, y);
        }
        
        int answer = 0;
        
        for(int i = 0; i < 100; i++) {
            for(int j = 0; j < 100; j++) {
                //4점 중 한곳이 체크가 되어 있지 않다면 continue
                if (!check[i][j]) {
                    continue;
                }
                
                if (!check[i + 1][j]) {
                    continue;
                }
                
                if (!check[i][j + 1]) {
                    continue;
                }
                
                if (!check[i + 1][j + 1]) {
                    continue;
                }
                
                //4개의 점이 check가 되어있다면,
                answer += 1;
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void recordDirection(int dir, int generation) {
        dirList.add(dir);
        
        //세대 만큼 반복
        for(int i = 0; i < generation; i++) {
            
            //회전을 하는 부분에서 반시계회전이고, 제일 나중에 있었던 방향이 첫 방향이 된다.
            for(int j = dirList.size() - 1; j >= 0; j--) {
                int newDir = (dirList.get(j) + 1) % 4;
                dirList.add(newDir);
            }
        }
    }
    
    private static void move(int x, int y) {
        //초기 시작 true 처리
        check[x][y] = true;
        
        for(int dir: dirList) {
            if (dir == 0) {
                x += 1;
            }
            else if (dir == 1) {
                y -= 1;
            }
            else if (dir == 2) {
                x -= 1;
            }
            else {
                y += 1;
            }
            check[x][y] = true;
        }
    }
}
