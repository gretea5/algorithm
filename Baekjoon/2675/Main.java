import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int R = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for(int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                for(int j = 0; j < R; j++) {
                    sb.append(ch);
                }
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
