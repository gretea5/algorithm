import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
public class Main {
    static class Balloon {
        int number;
        int idx;
        Balloon(int number, int idx) {
            this.number = number;
            this.idx = idx;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Balloon> deque = new ArrayDeque<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 1; i <= N; i++) {
            deque.addLast(new Balloon(Integer.parseInt(st.nextToken()), i));
        }
        StringBuilder sb = new StringBuilder();
        Balloon removedBalloon = deque.removeFirst();
        int paper = removedBalloon.number;
        sb.append(removedBalloon.idx).append(" ");
        while(!deque.isEmpty()) {
            int move = Math.abs(paper);
            if(paper > 0) {
                for(int i = 0; i < move - 1; i++) {
                    deque.addLast(deque.removeFirst());
                }
                removedBalloon = deque.removeFirst();
            }
            else {
                for(int i = 0; i < move - 1; i++) {
                    deque.addFirst(deque.removeLast());
                }
                removedBalloon = deque.removeLast();
            }
            paper = removedBalloon.number;
            sb.append(removedBalloon.idx).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
