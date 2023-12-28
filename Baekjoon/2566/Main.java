import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        for(int i = 1; i <= 9; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= 9; j++) {
                int element = Integer.parseInt(st.nextToken());
                if (max < element) {
                    max = element;
                    row = i;
                    col = j;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(row).append(" ").append(col);
        System.out.print(sb.toString());
        br.close();
    }
}
