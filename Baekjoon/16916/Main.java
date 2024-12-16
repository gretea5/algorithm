import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static final int K1 = 29;
    private static final int K2 = 31;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String p = br.readLine();

        int sLength = s.length();
        int pLength = p.length();

        //부분문자열이 길이가 더 길면 안된다.
        if (pLength > sLength) {
            System.out.print(0);
            return;
        }

        int sHash1 = 0;
        int pHash1 = 0;

        int power = 1;

        int answer = 0;

        for (int i = 0; i <= sLength - pLength; i++) {
            if (i == 0) {
                for (int j = 0; j < pLength; j++) {
                    sHash1 += hash(s.charAt(pLength - 1 - j), power);
                    pHash1 += hash(p.charAt(pLength - 1 - j), power);

                    if (j < pLength - 1) {
                        power *= K1;
                    }
                }
            }
            else {
                sHash1 = K1 * (sHash1 - (s.charAt(i - 1) * power)) + s.charAt(pLength + i - 1);
            }

            if (sHash1 == pHash1) {
                answer = 1;
                break;
            }
        }

        System.out.print(answer);

        br.close();
    }

    private static int hash(int value, int power) {
        return value * power;
    }
}
