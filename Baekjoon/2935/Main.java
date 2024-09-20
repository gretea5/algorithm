import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger a = new BigInteger(br.readLine());

        String operator = br.readLine();

        BigInteger b = new BigInteger(br.readLine());

        if (operator.equals("*")) {
            System.out.print(a.multiply(b));
        }
        else {
            System.out.print(a.add(b));
        }

        br.close();
    }
}
