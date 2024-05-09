import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Iterator;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = 10;

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            int testNumber = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());

            ArrayDeque<Integer> queue = new ArrayDeque<>();

            for(int i = 0; i < 8; i++) {
                queue.addLast(Integer.parseInt(st.nextToken()));
            }

            int minus = 1;

            while(true) {
                if (check(queue) && queue.peekLast() == 0) {
                    break;
                }

                int first = queue.removeFirst();

                first -= minus;

                if (first < 0) {
                    first = 0;
                }

                queue.addLast(first);

                minus = (minus % 5) + 1;
            }

            sb.append("#").append(testNumber).append(" ");

            while(!queue.isEmpty()) {
                sb.append(queue.removeFirst()).append(" ");
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static boolean check(ArrayDeque<Integer> queue) {
        Iterator<Integer> itr = queue.iterator();

        while(itr.hasNext()) {
            if (itr.next() >= 10) {
                return false;
            }
        }

        return true;
    }
}
