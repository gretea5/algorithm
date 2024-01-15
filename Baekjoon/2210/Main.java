import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

class Main {
    private static int SIZE = 5;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {-1, 1, 0, 0};
    private static int[][] arr;
    private static HashSet<String> set;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //집합, 배열 초기화
        arr = new int[SIZE][SIZE];
        set = new HashSet<>();

        //배열 입력
        for(int i = 0; i < SIZE; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < SIZE; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //dfs 호출
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                dfs(i, j, arr[i][j] + "");
            }
        }

        //출력
        System.out.print(set.size());
        br.close();
    }

    private static void dfs(int x, int y, String s) {
        //6자리가 되었을때,
        if(s.length() == SIZE + 1) {
            set.add(s);
            return;
        }

        //칸 이동
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx < 0 || mx >= SIZE || my < 0 || my >= SIZE) continue;
            dfs(mx, my, s + arr[mx][my]);
        }
    }

}
