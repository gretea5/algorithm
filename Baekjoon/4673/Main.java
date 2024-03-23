import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    private static final int MAX = 10001;
    public static void main(String[] args) throws IOException {
        boolean[] isSelfNumber = new boolean[MAX];

        Arrays.fill(isSelfNumber, true);

        for(int i = 1; i < MAX; i++) {
            if(!isSelfNumber[i]) continue;

            int selfNumber = calSelfNumber(i);

            while(true) {
                if(selfNumber >= MAX) {
                    break;
                }

                isSelfNumber[selfNumber] = false;

                selfNumber = calSelfNumber(selfNumber);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i < MAX; i++) {
            if(isSelfNumber[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb);
    }

    private static int calSelfNumber(int n) {
        String str = String.valueOf(n);

        int sum = 0;

        for(int i = 0; i < str.length(); i++) {
            sum += str.charAt(i) - '0';
        }

        sum += n;

        return sum;
    }
}
