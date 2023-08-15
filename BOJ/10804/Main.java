import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;
public class Main {
    private static int[] cards;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        cards = new int[21];
        for(int i = 1; i <= 20; i++) {
            cards[i] = i;
        }
        for(int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            reverseCards(start, end);
        }
        for(int i = 1; i <= 20; i++) {
            sb.append(cards[i]).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
    private static void reverseCards(int start, int end) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for(int i = start; i <= end; i++) {
            stack.addFirst(cards[i]);
        }
        for(int i = start; i <= end; i++) {
            cards[i] = stack.removeFirst();
        }
    }
}
