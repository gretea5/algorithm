import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> list = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }
        Collections.sort(list);
        for (int n : list) {
            sb.append(n).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
