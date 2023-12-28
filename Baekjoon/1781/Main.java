import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.PriorityQueue;
public class Main {
    private static class Question{
        int deadLine;
        int count;
        Question(int deadLine, int count) {
            this.deadLine = deadLine;
            this.count = count;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Question[] arr= new Question[N];
        //입력
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int deadLine = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            arr[i] = new Question(deadLine, count);
        }
        //정렬
        Arrays.sort(arr, (o1, o2) -> o1.deadLine - o2.deadLine);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(Question question : arr) {
            int size = pq.size();
            if(size < question.deadLine) {
                pq.offer(question.count);
            }
            else if (size == question.deadLine) {
                if(pq.peek() < question.count) {
                    pq.poll();
                    pq.offer(question.count);
                }
            }
        }
        int count = 0;
        while(!pq.isEmpty()) count += pq.poll();
        System.out.print(count);
        br.close();
    }
}
