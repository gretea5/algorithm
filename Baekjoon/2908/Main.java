import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        String str1 = st.nextToken();
        String str2 = st.nextToken();
        StringBuilder sb = new StringBuilder(str1);
        int num1 = Integer.parseInt(sb.reverse().toString());
        sb = new StringBuilder(str2);
        int num2 = Integer.parseInt(sb.reverse().toString());
        if(num1 < num2) {
            System.out.print(num2);
        } else if(num1 > num2) {
            System.out.print(num1);
        }
        br.close();
    }
}
