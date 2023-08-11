import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
public class Main {
    private static long N, P, Q;
    private static HashMap<Long, Long> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        map = new HashMap<>();
        N = Long.parseLong(st.nextToken());
        P = Long.parseLong(st.nextToken());
        Q = Long.parseLong(st.nextToken());
        System.out.print(solve(N));
        br.close();
    }
    private static Long solve(long N) {
        if(N == 0) {
            return Long.valueOf(1);
        }
        if(map.containsKey(N)) {
            return map.get(N);
        }
        map.put(N, solve(N / P) + solve(N / Q));
        return map.get(N);
    }
}
