import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        HashMap<String, String> pwBook = new HashMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            String address = st.nextToken();
            String password = st.nextToken();
            pwBook.put(address, password);
        }
        for(int i = 0; i < M; i++) {
            sb.append(pwBook.get(br.readLine())).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
