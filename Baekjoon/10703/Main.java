import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static class Pos {
        int x, y;
        
        Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    
    private static int r, s;
    private static char[][] map;
    private static boolean[] checked;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        r = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        map = new char[r][s];
        checked = new boolean[s];
        
        ArrayList<Pos> pList = new ArrayList<>();
        
        for (int i = 0; i < r; i++) {
            String str = br.readLine();
            
            for (int j = 0; j < s; j++) {
                char ch = str.charAt(j);
                
                map[i][j] = ch;
            }
        }
        
        for (int i = r - 1; i >= 0; i--) {
            for (int j = 0; j < s; j++) {
                //유성을 아래 행부터 넣기
                if (map[i][j] == 'X') {
                    pList.add(new Pos(i, j));
                }
            }
        }
        
        //최소이동거리
        int minDistance = Integer.MAX_VALUE;
        
        for (Pos p : pList) {
            int y = p.y;
            
            //행의 제일 하단이 최소 거리를 갱신하면 true가 되어 최적화를 할 수 있음
            if (!checked[y]) {
                minDistance = Math.min(minDistance, calGroundDist(p.x, p.y));
                
                checked[y] = true;
            }
        }
        
        //하단 행부터 유성의 위치를 옮김
        for (Pos p : pList) {
            int x = p.x;
            int y = p.y;
            
            map[x][y] = '.';
            map[x + minDistance][y] = 'X';
        }
        
        StringBuilder sb = new StringBuilder();
        
        //출력
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < s; j++) {
                sb.append(map[i][j]);
            }
            
            sb.append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    //유성부터 지면의 거리를 계산
    private static int calGroundDist(int x, int y) {
        //시작 행(초기 행)
        int mx = x;
        
        while(true) {
            mx += 1;
            
            //범위를 벗어나거나, 땅을 만나면 -1한 값(행)이 유성이 이동할 수 있는 점
            if (mx >= r || map[mx][y] == '#') {
                mx -= 1;
                break;
            }
        }
        
        return mx - x;
    }
}
