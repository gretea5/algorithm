import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int answer = 0;
        for(int h = 0; h <= N; h++) {
            for(int m = 0; m < 60; m++) {
                for(int s = 0; s < 60; s++) {
                    StringBuilder sb = new StringBuilder();
                    if (h < 10) {
                        sb.append("0").append(h);
                    }
                    else {
                        sb.append(h);
                    }
                    if (m < 10) {
                        sb.append("0").append(m);
                    }
                    else {
                        sb.append(m);
                    }
                    if (s < 10) {
                        sb.append("0").append(s);
                    }
                    else {
                        sb.append(s);
                    }
                    String timeStr = sb.toString();
                    if(timeStr.contains(String.valueOf(K))) {
                        answer += 1;
                    }
                }
            }
        }
        System.out.print(answer);
        br.close();
    }
}
