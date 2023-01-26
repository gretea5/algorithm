import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int[] answer = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i = N - 1; i >=0; i--) {
            while(!ad.isEmpty() && ad.peekFirst() <= arr[i]) {
                ad.pollFirst();
            }
            if (ad.isEmpty()) {
                answer[i] = -1;
            }
            else {
                answer[i] = ad.peekFirst();
            }
            ad.offerFirst(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            sb.append(answer[i]).append(" ");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
