import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int command = Integer.parseInt(st.nextToken());
            if(command == 1) {
                stack.addFirst(Integer.parseInt(st.nextToken()));
            }
            else if (command == 2) {
                sb.append((!stack.isEmpty() ? stack.removeFirst() : -1)).append("\n");
            }
            else if (command == 3) {
                sb.append(stack.size()).append("\n");
            }
            else if (command == 4) {
                sb.append((stack.isEmpty() ? 1 : 0)).append("\n");
            }
            else {
                sb.append((!stack.isEmpty() ? stack.peekFirst() : -1)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
