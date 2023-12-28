import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if(command == 1) {
                int X = Integer.parseInt(st.nextToken());
                deque.addFirst(X);
            } else if (command == 2) {
                int X = Integer.parseInt(st.nextToken());
                deque.addLast(X);
            } else if (command == 3) {
                sb.append(!deque.isEmpty() ? deque.removeFirst() : -1).append("\n");
            } else if (command == 4) {
                sb.append(!deque.isEmpty() ? deque.removeLast() : -1).append("\n");
            } else if (command == 5) {
                sb.append(deque.size()).append("\n");
            } else if (command == 6) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (command == 7) {
                sb.append(!deque.isEmpty() ? deque.peekFirst() : -1).append("\n");
            } else {
                sb.append(!deque.isEmpty() ? deque.peekLast() : -1).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
