import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
public class Main {
    static class Tower {
        int height;
        int order;
        Tower(int height, int order) {
            this.height = height;
            this.order = order;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Tower> stack = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            int currentHeight = Integer.parseInt(st.nextToken());
            if (stack.isEmpty()) {
                sb.append("0").append(" ");
                stack.addFirst(new Tower(currentHeight, i));
            }
            else {
                while(true) {
                    if (stack.isEmpty()) {
                        sb.append("0").append(" ");
                        stack.push(new Tower(currentHeight, i));
                        break;
                    }
                    Tower leftTower = stack.peekFirst();
                    if(leftTower.height < currentHeight) {
                        stack.removeFirst();
                    }
                    else {
                        sb.append(leftTower.order).append(" ");
                        stack.addFirst(new Tower(currentHeight, i));
                        break;
                    }
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}
