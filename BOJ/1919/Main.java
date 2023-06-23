import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] alpha = new int[26];
        char[] c1 = br.readLine().toCharArray();
        char[] c2 = br.readLine().toCharArray();
        for(char c : c1) alpha[c - 'a']++;
        for(char c : c2) alpha[c - 'a']--;
        int answer = 0;
        for(int i : alpha) {
            int num = Math.abs(i);
            answer += num;
        }
        System.out.print(answer);
        br.close();
    }
}
