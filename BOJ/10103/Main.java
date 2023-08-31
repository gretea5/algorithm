import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int c = 100;
        int s = 100;
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int cDice = Integer.parseInt(st.nextToken());
            int sDice = Integer.parseInt(st.nextToken());
            if (cDice < sDice) {
                c -= sDice;
            }
            else if (cDice > sDice) {
                s -= cDice;
            }
        }
        System.out.println(c);
        System.out.print(s);
        br.close();
    }
}
