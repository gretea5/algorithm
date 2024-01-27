import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;

    private static boolean[][] visited;
    private static char[][] campus;

    private static int answer;

    private static int[] dx = {1, -1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //N, M 입력
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        //방문 배열, 그래프 배열 초기화
        visited = new boolean[N][M];
        campus = new char[N][M];

        //그래프에 입력
        for(int i = 0; i < N; i++) {
            String input = br.readLine();
            for(int j = 0; j < M; j++) {
                campus[i][j] = input.charAt(j);
            }
        }

        //사람의 수 초기화
        answer = 0;

        //도연이가 있는 위치에서 dfs 호출
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(campus[i][j] == 'I') dfs(i, j);
            }
        }

        System.out.print(answer == 0 ? "TT" : answer);

        br.close();
    }

    private static void dfs(int x, int y) {
        //방문처리
        visited[x][y] = true;

        //사람을 만났을 경우 사람의 수 증가
        if(campus[x][y] == 'P') answer += 1;

        for(int i = 0; i < 4; i++) {
            //움직임
            int mx = x + dx[i];
            int my = y + dy[i];

            //범위에서 벗어날 경우,
            if(mx < 0 || mx >= N || my < 0 || my >= M) continue;

            //벽이 아니면서, 방문이 안되었다면 갈 수 있음!
            if(!visited[mx][my] && campus[mx][my] != 'X') {
                dfs(mx, my);
            }
        }
    }
}
