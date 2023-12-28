import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        //시간 배열
        int[] times = new int[N + 1];
        //진입 차수
        int[] inDegrees = new int[N + 1];
        //이전에 지어져야할 빌딩들의 개수 기록
        ArrayList<Integer>[] list = new ArrayList[N + 1];
        for(int i = 1; i <= N; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            times[i] = Integer.parseInt(st.nextToken());
            while(true) {
                int building = Integer.parseInt(st.nextToken());
                if(building == -1) break;
                //이전 building을 기준으로 i가 지어져아한다.
                list[building].add(i);
                inDegrees[i] += 1;
            }
        }
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int[] results = new int[N + 1];
        for(int i = 1; i <= N; i++) {
            if(inDegrees[i] == 0) {
                queue.addLast(i);
                results[i] = times[i];
            }
        }
        while(!queue.isEmpty()) {
            int current = queue.removeFirst();
            for(int i = 0; i < list[current].size(); i++) {
                //current를 기준으로 i가 지어져아한다.
                int next = list[current].get(i);
                results[next] = Math.max(results[next], results[current] + times[next]);
                inDegrees[next] -= 1;
                if(inDegrees[next] == 0) queue.addLast(next);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++) {
            sb.append(results[i]).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
