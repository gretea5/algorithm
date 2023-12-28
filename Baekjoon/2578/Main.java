import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][] arr = new int[5][5];
    static boolean[][] isChecked = new boolean[5][5];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                isChecked[i][j] = false;
            }
        }
        int answer = 0;
        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < 5; j++) {
                int num = Integer.parseInt(st.nextToken());
                callNumber(num);
                answer += 1;
                if (checkBingo() >= 3) {
                    System.out.print(answer);
                    return;
                }
            }
        }
        br.close();
    }
    public static void callNumber(int num) {
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(arr[i][j] == num) {
                    isChecked[i][j] = true;
                    return;
                }
            }
        }
    }
    public static int checkBingo() {
        int count = 0;
        if (isChecked[0][0] && isChecked[1][1] && isChecked[2][2] && isChecked[3][3] && isChecked[4][4]) {
            count += 1;
        }
        if (isChecked[0][4] && isChecked[1][3] && isChecked[2][2] && isChecked[3][1] && isChecked[4][0]) {
            count += 1;
        }
        for(int i = 0; i < 5; i++) {
            if(isChecked[i][0] && isChecked[i][1] && isChecked[i][2] && isChecked[i][3] && isChecked[i][4]) {
                count += 1;
            }
            if(isChecked[0][i] && isChecked[1][i] && isChecked[2][i] && isChecked[3][i] && isChecked[4][i]) {
                count += 1;
            }
        }
        return count;
    }
}
