import java.util.ArrayList;
import java.util.Collections;

class Solution {
    private static char[][] board;
    private static boolean[][] visited;
    
    private static ArrayList<Integer> ans;
    
    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, 1, -1};
    
    private static int x, y;
    
    private static int sum;
    
    public int[] solution(String[] maps) {
        
        //세로의 길이 가로의 길이
        y = maps.length;
        x = maps[0].length();
        
        //배열 선언
        board = new char[y][x];
        visited  = new boolean[y][x];
        
        //board에 문자 넣기
        for(int i = 0; i < y; i++) {
            String map = maps[i];
            for(int j = 0; j < x; j++) {
                board[i][j] = map.charAt(j);
            }
        }
        
        ans = new ArrayList<>();
        
        //영역의 식량의 합
        sum = 0;
        
        for(int i = 0; i < y; i++) {
            for(int j = 0; j < x; j++) {
                //섬이라면
                if(board[i][j] != 'X' && !visited[i][j]) {
                    //dfs
                    dfs(i, j);
                    //식량의 합 넣기
                    ans.add(sum);
                    sum = 0;
                }
            }
        }
        //list에 아무것도 없다면, 즉 섬이 없었다면,
        if(ans.size() == 0) {
            return new int[] {-1};
        }
        
        //오름차순 정렬
        Collections.sort(ans);
        
        int[] answer = new int[ans.size()];
        
        for(int i = 0; i < answer.length; i++) {
            answer[i] = ans.get(i);
        }
        
        return answer;
    }
    
    private static void dfs(int startY, int startX) {
        //방문 처리
        visited[startY][startX] = true;
        //문자니까
        sum += board[startY][startX] - '0';
        
        for(int i = 0; i < 4; i++) {
            int my = startY + dy[i];
            int mx = startX + dx[i];
            
            //영역에 벗어나는 경우
            if(my < 0 || my >= y || mx < 0 || mx >= x) continue;
            
            //섬의 영역이 존재하는 경우
            if(board[my][mx] != 'X' && !visited[my][mx]) {
                dfs(my, mx);
            }
        }
    }
}
