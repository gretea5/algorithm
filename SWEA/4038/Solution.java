import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    private static final int K1 = 37;
    private static final int K2 = 41;
    private static final int K3 = 43;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            String parent = br.readLine();
            String pattern = br.readLine();

            int parentSize = parent.length();
            int patternSize = pattern.length();

            int parentHash1 = 0;
            int patternHash1 = 0;

            int parentHash2 = 0;
            int patternHash2 = 0;

            int parentHash3 = 0;
            int patternHash3 = 0;

            int power1 = 1;
            int power2 = 1;
            int power3 = 1;

            int answer = 0;

            for(int i = 0; i <= parentSize - patternSize; i++) {
                if (i == 0) {
                    for(int j = 0; j < patternSize; j++) {
                        parentHash1 += hash(parent.charAt(patternSize - 1 - j), power1);
                        patternHash1 += hash(pattern.charAt(patternSize - 1 - j), power1);

                        parentHash2 += hash(parent.charAt(patternSize - 1 - j), power2);
                        patternHash2 += hash(pattern.charAt(patternSize - 1 - j), power2);

                        parentHash3 += hash(parent.charAt(patternSize - 1 - j), power3);
                        patternHash3 += hash(pattern.charAt(patternSize - 1 - j), power3);

                        if (j < patternSize - 1) {
                            power1 *= K1;
                            power2 *= K2;
                            power3 *= K3;
                        }
                    }

                } else {
                    parentHash1 = K1 * (parentHash1 - hash(parent.charAt(i - 1), power1)) + parent.charAt(i + patternSize - 1);
                    parentHash2 = K2 * (parentHash2 - hash(parent.charAt(i - 1), power2)) + parent.charAt(i + patternSize - 1);
                    parentHash3 = K3 * (parentHash3 - hash(parent.charAt(i - 1), power3)) + parent.charAt(i + patternSize - 1);
                }

                if(parentHash1 == patternHash1 && parentHash2 == patternHash2 && parentHash3 == patternHash3) {
                    answer += 1;
                }
            }

            sb.append(answer);
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int hash(int value, int power) {
        return value * power;
    }
}
