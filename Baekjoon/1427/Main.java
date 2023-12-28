import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            list.add((int) ch - '0');
        }
        Collections.sort(list, Collections.reverseOrder());
        StringBuilder sb = new StringBuilder();
        for(int n : list) {
            sb.append(n);
        }
        System.out.print(sb);
        br.close();
    }
}
