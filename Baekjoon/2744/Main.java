import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for(int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if('a' <= c && c <= 'z') {
                int num = (int) c - 32;
                System.out.print((char) num);
            } else if ('A' <= c && c <= 'Z') {
                int num = (int) c + 32;
                System.out.print((char) num);
            }
        }
        br.close();
    }
}
