import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        double[] scores = new double[N];
        for(int i = 0; i < N; i++) {
            scores[i] = Double.parseDouble(st.nextToken());
        }
        double max = Double.MIN_VALUE;
        for(double v : scores) {
            max = Math.max(max, v);
        }
        double sum = 0.0;
        for(int i = 0; i < N; i++) {
            sum += (scores[i] / max) * 100;
        }
        System.out.print(sum / N);
        br.close();
    }
}
