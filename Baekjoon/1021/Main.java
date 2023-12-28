import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        LinkedList<Integer> list = new LinkedList<>();
        for(int i = 1; i <= N; i++) {
            list.add(i);
        }
        int answer = 0;
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            int num = Integer.parseInt(st.nextToken());
            int targetIdx = list.indexOf(num);
            int halfIdx = list.size() / 2;
            if(targetIdx <= halfIdx) {
                while(num != list.getFirst()) {
                    list.addLast(list.removeFirst());
                    answer += 1;
                }
            }
            else {
                while(num != list.getFirst()) {
                    list.addFirst(list.removeLast());
                    answer += 1;
                }
            }
            list.removeFirst();
        }
        System.out.print(answer);
        br.close();
    }
}
