import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int countArr[] = new int[26];
        Arrays.fill(countArr, -1);
        for(int i = 0; i < input.length(); i++) {
            if(countArr[input.charAt(i) - 'a'] == -1) {
                countArr[input.charAt(i) - 'a'] = i;
            }
        }
        for(int i = 0; i < countArr.length; i++){
            System.out.print(countArr[i] + " ");
        }
        br.close();
    }
}
