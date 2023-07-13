import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static String[] numArr= {"000", "001", "010", "011", "100", "101", "110", "111"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        StringBuilder sb = new StringBuilder();
        if (input.equals("0"))  {
            System.out.print(0);
            return;
        }
        for(int i = 0; i < input.length(); i++) {
            int num = input.charAt(i) - '0';
            sb.append(numArr[num]);
        }
        while(sb.charAt(0) == '0') sb = new StringBuilder(sb.substring(1));
        System.out.print(sb);
        br.close();
    }
}
