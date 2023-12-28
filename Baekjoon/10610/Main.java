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
        int sum = 0;
        for(int i = 0; i < input.length(); i++) {
            list.add((int)input.charAt(i) - '0');
            sum += ((int)input.charAt(i) - '0');
        }
        //list에 0이 포홤되어 있지 않다면, 즉 10의 배수가 되지 않으므로,
        if(!list.contains(0) || sum % 3 != 0) {
            System.out.print(-1);
            return;
        }
        Collections.sort(list, Collections.reverseOrder());
        for(int n : list) {
            System.out.print(n);
        }
        br.close();
    }
}

