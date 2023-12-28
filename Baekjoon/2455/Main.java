import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int stationNum = 4;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int answer = Integer.MIN_VALUE;
        for(int i = 0; i < stationNum; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());
            sum -= out;
            sum += in;
            answer = Math.max(sum, answer);
        }
        System.out.print(answer);
        br.close();
    }
}
