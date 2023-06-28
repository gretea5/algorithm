import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int start = 0;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        while(n-- > 0) {
            int target = Integer.parseInt(br.readLine());
            if (start < target) {
                for(int i = start + 1; i <= target; i++) {
                    stack.addFirst(i);
                    sb.append("+").append("\n");
                }
                start = target;
            }
            else if (stack.peekFirst() != target) {
                System.out.print("NO");
                return;
            }
            stack.removeFirst();
            sb.append("-").append("\n");
        }
        System.out.print(sb.toString());
        br.close();
    }
}
