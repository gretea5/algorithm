import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());
        int result = A * B * C;
        String str = String.valueOf(result);
        int countArr[] = new int[10];
        Arrays.fill(countArr, 0);
        for(int i = 0; i < str.length(); i++) {
           countArr[str.charAt(i) - '0'] += 1;
        }
        for(int i = 0; i < countArr.length; i++) {
            System.out.println(countArr[i]);
        }
        br.close();
    }
}
