import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        boolean[][] attached = new boolean[101][101];

        for(int t = 0; t < N; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            for(int i = y; i < y + 10; i++) {
                for(int j = x; j < x + 10; j++) {
                    attached[i][j] = true;
                }
            }
        }

        int answer = 0;

        for(int i = 0; i < attached.length; i++) {
            for(int j = 0; j < attached[i].length; j++) {
                if(attached[i][j]) answer += 1;
            }
        }

        System.out.print(answer);

        br.close();
    }
}
