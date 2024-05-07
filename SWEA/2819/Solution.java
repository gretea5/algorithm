import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Solution {
    private static int[][] board;

    private static final int size = 4;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static HashSet<String> set;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            board = new int[size][size];

            for(int i = 0; i < size; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for(int j = 0; j < size; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            set = new HashSet<>();

            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    backTrack(i, j, String.valueOf(board[i][j]), 1);
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(set.size()).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void backTrack(int x, int y, String s, int depth) {
        if (depth == 7) {
            set.add(s);
            return;
        }

        for(int i = 0; i < 4; i++) {
            int mx = x + dx[i];
            int my = y + dy[i];

            if (mx < 0 || mx >= size || my < 0 || my >= size) {
                continue;
            }

            backTrack(mx, my, s + board[mx][my], depth + 1);
        }
    }
}
