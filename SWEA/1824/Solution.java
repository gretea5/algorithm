import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Solution {
    private static int r;
    private static int c;
    private static String answer;

    private static char[][] board;
    private static boolean[][][][] visited;

    private static int[] dx = {0, 0, -1, 1};
    private static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            board = new char[r][c];

            boolean isFinish = false;

            for(int i = 0; i < r; i++) {
                String s = br.readLine();

                for(int j = 0; j < c; j++) {
                    board[i][j] = s.charAt(j);

                    if (board[i][j] == '@') {
                        isFinish = true;
                    }
                }
            }

            answer = "NO";

            if (isFinish) {
                visited = new boolean[r][c][4][16];

                dfs(0, 0, 0, 0);
            }

            sb.append("#").append(test).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void dfs(int x, int y, int dir, int memory) {
        if (answer.equals("YES")) {
            return;
        }

        visited[x][y][dir][memory] = true;

        int newDir = dir;
        int newMemory = memory;

        char command = board[x][y];

        if (command == '<') {
            newDir = 1;
        }
        else if (command == '>') {
            newDir = 0;
        }
        else if (command == '^') {
            newDir = 2;
        }
        else if (command == 'v') {
            newDir = 3;
        }
        else if (command == '_') {
            if (memory == 0) {
                newDir = 0;
            }
            else {
                newDir = 1;
            }

        }
        else if (command == '|') {
            if (memory == 0) {
                newDir = 3;
            }
            else {
                newDir = 2;
            }
        }
        else if (command == '@') {
            answer = "YES";
        }
        else if ('0' <= command && command <= '9') {
            newMemory = command - '0';
        }
        else if (command == '+') {
            newMemory = memory + 1;

            if (newMemory == 16) {
                newMemory = 0;
            }
        }
        else if (command == '-') {
            newMemory = memory - 1;

            if (newMemory == -1) {
                newMemory = 15;
            }
        }

        if (command == '?') {
            for(int i = 0; i < 4; i++) {
                newDir = (dir + i) % 4;

                int mx = x + dx[newDir];
                int my = y + dy[newDir];

                if (mx == -1) {
                    mx = r - 1;
                }
                else if (mx == r) {
                    mx = 0;
                }

                if (my == -1) {
                    my = c - 1;
                }
                else if (my == c) {
                    my = 0;
                }

                if (!visited[mx][my][newDir][newMemory]) {
                    dfs(mx, my, newDir, newMemory);
                }
            }

            return;
        }

        int mx = x + dx[newDir];
        int my = y + dy[newDir];

        if (mx == -1) {
            mx = r - 1;
        }
        else if (mx == r) {
            mx = 0;
        }

        if (my == -1) {
            my = c - 1;
        }
        else if (my == c) {
            my = 0;
        }

        if (!visited[mx][my][newDir][newMemory]) {
            dfs(mx, my, newDir, newMemory);
        }
    }
}
