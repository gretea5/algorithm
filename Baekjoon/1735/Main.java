import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.StringTokenizer;
public class Main {
    private static int a1, b1, a2, b2;
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        a1 = Integer.parseInt(st.nextToken());
        b1 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        a2 = Integer.parseInt(st.nextToken());
        b2 = Integer.parseInt(st.nextToken());
        br.close();
    }
    private static void solve() {
        int son = (a1 * b2) + (a2 * b1);
        int mother = b1 * b2;
        int divNumber = calMaxDivNumber(son, mother);
        System.out.print(son / divNumber + " " + mother / divNumber);
    }
    private static int calMaxDivNumber(int n1, int n2) {
        while(n2 != 0) {
            int temp = n2;
            n2 = n1 % n2;
            n1 = temp;
        }
        return n1;
    }
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
