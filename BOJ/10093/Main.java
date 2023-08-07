import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        if(A == B) {
            System.out.print(0);
            return;
        }
        if (A > B) {
            long temp = A;
            A = B;
            B = temp;
        }
        long count =  B - A - 1;
        sb.append(count).append("\n");
        for(long i = A + 1; i < B; i++) {
            sb.append(i).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
