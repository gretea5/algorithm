import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        long answer = 0;
        for(int i = 0; i < N; i++) {
            int height = Integer.parseInt(br.readLine());
            while(!stack.isEmpty() && stack.peekFirst() <= height) {
                stack.removeFirst();
            }
            answer += stack.size();
            stack.addFirst(height);
        }
        System.out.print(answer);
        br.close();
    }
}
