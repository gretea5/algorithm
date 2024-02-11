import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        String reverseStr = new StringBuilder(str).reverse().toString();

        System.out.print(str.equals(reverseStr) ? 1 : 0);

        br.close();
    }
}
