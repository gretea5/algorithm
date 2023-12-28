import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str, "R");
        int BLength = st.countTokens();
        st = new StringTokenizer(str, "B");
        int RLength = st.countTokens();
        int answer = 0;
        if(BLength > RLength) {
            answer = 1 + RLength;
        } else {
            answer = 1 + BLength;
        }
        System.out.print(answer);
        br.close();
    }
}
