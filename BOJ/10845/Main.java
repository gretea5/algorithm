import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if (command.equals("pop")) {
                System.out.println((deque.isEmpty() ? -1 : deque.pollLast()));
            } else if (command.equals("size")) {
                System.out.println(deque.size());
            } else if (command.equals("empty")) {
                System.out.println((deque.isEmpty() ? 1 : 0));
            } else if (command.equals("front")) {
                System.out.println((deque.isEmpty() ? -1 : deque.peekLast()));
            } else if (command.equals("back")) {
                System.out.println((deque.isEmpty() ? -1 : deque.peekFirst()));
            }
        }
        br.close();
    }
}

