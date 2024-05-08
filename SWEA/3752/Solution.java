import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            int n = Integer.parseInt(br.readLine());

            int[] arr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            HashSet<Integer> set = new HashSet<>();

            for(int score : arr) {
                ArrayList<Integer> setList = new ArrayList<>(set);

                for(int total : setList) {
                    set.add(score + total);
                }

                set.add(score);
            }

            //모두 틀렸을 경우 고려
            set.add(0);

            sb.append("#").append(test).append(" ");
            sb.append(set.size()).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
