import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static int[][] board;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        board = new int[R][C];

        for(int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int T = Integer.parseInt(br.readLine());
        int answer = 0;

        for(int x = 0; x <= R - 3; x++) {
            for(int y = 0; y <= C - 3; y++) {
                if(calCenterValue(x, y) >= T) {
                    answer += 1;
                }
            }
        }

        System.out.print(answer);

        br.close();
    }

    private static int calCenterValue(int x, int y) {
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = x; i < x + 3; i++) {
            for(int j = y; j < y + 3; j++) {
                arr.add(board[i][j]);
            }
        }

        Collections.sort(arr);

        return arr.get(4);
    }
}
