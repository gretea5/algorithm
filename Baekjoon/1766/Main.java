import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer>[] graph;
    private static int[] inDegree;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        graph = new ArrayList[n + 1];
        inDegree = new int[n + 1];
        
        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            graph[a].add(b);
            
            //진입 차수 기록
            inDegree[b] += 1;
        }
        
        //쉬운 문제는 문제 번호가 작은 순이므로, 정렬을 유지하기 위해 우선순위 큐를 사용한다.
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        //진입 차수가 0인애들을 넣어준다.
        for(int i = 1; i < n + 1; i++) {
            if (inDegree[i] == 0) {
                pq.add(i);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        while(!pq.isEmpty()) {
            int cur = pq.remove();
            
            sb.append(cur).append(" ");
            
            for(int next: graph[cur]) {
                inDegree[next] -= 1;
                
                if(inDegree[next] == 0) {
                    pq.add(next);
                }
            }
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
