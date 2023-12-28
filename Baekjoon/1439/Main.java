import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringTokenizer st = new StringTokenizer(input, "0");
        int oneCount = st.countTokens();
        st = new StringTokenizer(input, "1");
        int zeroCount = st.countTokens();
        int answer = Math.min(oneCount, zeroCount);
        System.out.print(answer);
        br.close();
    }
}
