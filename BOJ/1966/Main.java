import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.LinkedList;

/*
    <이 문제를 풀지 못한 이유>
    1. 인덱스를 저장할 못함(2차원 배열로)
    2. 꼭 큐를 사용할 편협한 생각을 가져서 비교를 해야할 방법(get 메소드)을 잃어버림
    3. 큐 문제라고 꼭 Queue를 사용할 필요는 없다.
 */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int j = 0; j < T; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            LinkedList<int[]> q = new LinkedList<>();
            st = new StringTokenizer(br.readLine(), " ");
            for(int i = 0; i < N; i++) {
                q.offer(new int[]{i, Integer.parseInt(st.nextToken())});
            }
            int count = 0;
            while(q.size() != 0) {
                int front[] = q.poll();
                //flag (첫번째 값이 최댓값인지 아닌지)
                boolean isMax = true;
                for(int i = 0; i < q.size(); i++) {
                    //비교
                    if(front[1] < q.get(i)[1]) {
                        q.offer(front);
                        for(int k = 0; k < i; k++) {
                            q.offer(q.poll());
                        }
                        isMax = false;
                        break;
                    }
                }
                if(!isMax) {
                    continue;
                }
                count += 1;
                if(front[0] == M) break;
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
