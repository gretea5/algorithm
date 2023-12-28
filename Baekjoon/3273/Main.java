import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int[] arr = new int[n];
        int x = Integer.parseInt(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(st.nextToken());
            arr[i] = k;
            set.add(k);
        }
        int answer = 0;
        for(int i = 0; i < n; i++) {
            if (set.contains(x - arr[i])) {
                answer += 1;
            }
        }
        System.out.print(answer / 2);
        br.close();
    }
}
