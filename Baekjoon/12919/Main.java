import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static String s, t;
    private static int answer;

    public static void main(String[] args) throws IOException {
        input();
        solve();
    }

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        t = br.readLine();
        answer = 0;
        br.close();
    }

    private static void solve() {
        dfs(t);
        System.out.print(answer);
    }

    private static void dfs(String str) {
        if(s.length() == str.length()) {
            if(s.equals(str)) answer = 1;
            return;
        }

        if(str.charAt(str.length() - 1) == 'A') {
            dfs(str.substring(0, str.length() - 1));
        }

        if(str.charAt(0) == 'B') {
            StringBuilder sb = new StringBuilder(str.substring(1, str.length()));
            dfs(sb.reverse().toString());
        }
    }
}
