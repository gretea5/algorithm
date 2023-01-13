import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Set<Integer> set = new HashSet<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < M; i++) {
            int n = Integer.parseInt(st.nextToken());
            if(set.contains(n)) {
                sb.append(1).append(" ");
            }
            else {
                sb.append(0).append(" ");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
