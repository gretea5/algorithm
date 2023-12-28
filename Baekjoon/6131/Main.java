import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static int mulDouble(int n) { return n * n; }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int answer = 0;
        for(int B = 1; B <= 500; B++) {
            for(int A = B + 1; A <= 500; A++) {
                if(mulDouble(A) == mulDouble(B) + N) {
                    answer += 1;
                }
            }
        }
        System.out.print(answer);
        br.close();
    }
}
