import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        ArrayDeque<Integer> queue = new ArrayDeque<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for(int i = 0; i < N; i++) {
            queue.addLast(Integer.parseInt(st.nextToken()));
        }

        int order = 1;

        while(!queue.isEmpty()) {
            if(queue.peekFirst() == order) {
                queue.removeFirst();
                order += 1;
            }
            else if(!stack.isEmpty() && stack.peekFirst() == order) {
                stack.removeFirst();
                order += 1;
            }
            else {
                stack.addFirst(queue.removeFirst());
            }
        }

        while(!stack.isEmpty()) {
            if(stack.peekFirst() != order) {
                break;
            }
            stack.removeFirst();
            order += 1;
        }

        System.out.print(stack.isEmpty() ? "Nice" : "Sad");

        br.close();
    }
}
