import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine().toUpperCase();
        int[] count = new int['Z' - 'A' + 1];
        Arrays.fill(count, 0);
        for(int i = 0; i < input.length(); i++) {
            count[input.charAt(i) - 'A']++;
        }
        char answer = ' ';
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < count.length; i++) {
            if(max < count[i]) {
                max = count[i];
                answer = (char) ('A' + i);
            }
            else if (max == count[i]) {
                answer = '?';
            }
        }
        System.out.print(answer);
        br.close();
    }
}
