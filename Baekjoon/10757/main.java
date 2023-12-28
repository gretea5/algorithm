import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.math.BigDecimal;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigDecimal number1 = new BigDecimal(st.nextToken());
        BigDecimal number2 = new BigDecimal(st.nextToken());
        System.out.print(number1.add(number2));
        br.close();
    }
}
