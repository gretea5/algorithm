import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static int R, C;
    private static char[][] map;
    private static boolean[] alphaUsed;
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        answer = Integer.MIN_VALUE;
        for(int i = 0; i < R; i++) {
            String input = br.readLine();
            for(int j = 0; j < C; j++) {
                map[i][j] = input.charAt(j);
            }
        }
        alphaUsed = new boolean['Z' - 'A' + 1];
        alphaUsed[map[0][0] - 'A'] = true;
        backTrack(0, 0, 1);
        System.out.print(answer);
        br.close();
    }
    private static void backTrack(int x, int y, int length) {
        answer = Math.max(length, answer);
        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];
            if(mx < 0 || mx >= R || my < 0 || my >= C) {
                continue;
            }
            if(!alphaUsed[map[mx][my] - 'A']) {
                alphaUsed[map[mx][my] - 'A'] = true;
                backTrack(mx, my, length + 1);
                alphaUsed[map[mx][my] - 'A'] = false;
            }
        }
    }
}
