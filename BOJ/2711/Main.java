import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int h = 0; h < T; h++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int faultNumber = Integer.parseInt(st.nextToken());
            String str = st.nextToken();
            for(int i = 0; i < str.length(); i++) {
                if(i == faultNumber - 1) {
                    continue;
                }
                sb.append(str.charAt(i));
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}

