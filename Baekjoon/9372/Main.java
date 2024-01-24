import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;

    private static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            //국가의 수
            int N = Integer.parseInt(st.nextToken());
            //비행기의 종류
            int M = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            visited = new boolean[N + 1];

            //국가의 수 만큼 ArrayList 생성
            for(int i = 0; i < N + 1; i++) {
                graph.add(new ArrayList<>());
            }

            //비행기의 종류에 해당하는 나라 입력
            for(int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                //나라 입력
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                //나라 정보 그래프 기록
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            //비행기의 최소 개수
            count = 0;

            dfs(1);

            sb.append(count + "\n");
        }
        System.out.print(sb);
        br.close();
    }

    private static void dfs(int point) {
        visited[point] = true;

        for(int i = 0; i < graph.get(point).size(); i++) {
            //다음 정점
            int next = graph.get(point).get(i);

            //새로운 비행기 경로가 있을 경우
            if(!visited[next]) {
                //수를 증가
                count += 1;
                dfs(next);
            }
        }
    }
}
