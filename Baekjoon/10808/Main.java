import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = br.readLine();
        int alphaCountArr[] = new int[26];
        Arrays.fill(alphaCountArr, 0);
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            int idx = (int) ch - 'a';
            alphaCountArr[idx] += 1;
        }
        for(int i = 0; i < 26; i++) {
            sb.append(alphaCountArr[i]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
