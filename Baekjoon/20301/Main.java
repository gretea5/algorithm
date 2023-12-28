import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean flag = true;
        ArrayDeque<Integer> ad = new ArrayDeque<>();
        for(int i = 1; i <= N; i++) {
            ad.offerLast(i);
        }
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while(ad.size() != 0) {
            if (count == M)  {
                flag = !flag;
                count = 0;
            }
            if(flag) {
                for(int i = 0; i < K - 1; i++) {
                    ad.offerLast(ad.pollFirst());
                }
                sb.append(ad.pollFirst()).append("\n");

            }
            else {
                for(int i = 0; i < K - 1; i++) {
                    ad.offerFirst(ad.pollLast());
                }
                sb.append(ad.pollLast()).append("\n");
            }
            count += 1;
        }
        System.out.print(sb);
        br.close();
    }
}
