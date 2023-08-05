import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < T; k++) {
            String command = br.readLine();
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine(), "[],");
            boolean flag = true;
            boolean isError = false;
            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for(int i = 0; i < n; i++) {
                int v = Integer.parseInt(st.nextToken());
                deque.addLast(v);
            }
            for(int i = 0; i < command.length(); i++) {
                char c = command.charAt(i);
                if(c == 'R') {
                    flag = !flag;
                }
                else {
                    if (deque.isEmpty()) {
                         isError = true;
                         break;
                    }
                    else {
                       if (flag) {
                           deque.removeFirst();
                       }
                       else {
                           deque.removeLast();
                       }
                    }
                }
            }
            if (isError) {
                sb.append("error").append("\n");
                continue;
            }
            sb.append("[");
            int size = deque.size();
            for(int i = 0; i < size; i++) {
                if (i == size - 1) {
                    if (flag) {
                        sb.append(deque.removeFirst());
                    }
                    else {
                        sb.append(deque.removeLast());
                    }
                }
                else {
                    if (flag) {
                        sb.append(deque.removeFirst()).append(',');
                    }
                    else {
                        sb.append(deque.removeLast()).append(',');
                    }
                }
            }
            sb.append("]").append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
