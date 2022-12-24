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
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String command = st.nextToken();
            if(command.equals("push")) {
                int num = Integer.parseInt(st.nextToken());
                deque.addFirst(num);
            } else if (command.equals("pop")) {
                sb.append((deque.isEmpty() ? -1 : deque.pollLast())).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append((deque.isEmpty() ? 1 : 0)).append("\n");                
            } else if (command.equals("front")) {
                sb.append((deque.isEmpty() ? -1 : deque.peekLast())).append("\n");
            } else if (command.equals("back")) {
                sb.append((deque.isEmpty() ? -1 : deque.peekFirst())).append("\n");
            }
        }
        System.out.print(sb.toString());
        br.close();
    }
}

