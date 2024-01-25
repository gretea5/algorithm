import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static int[] arr;

    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //N 입력
        int N = Integer.parseInt(br.readLine());

        //방문 배열 및 정점을 담을 배열 초기화 및 ArrayList 초기화
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        graph = new ArrayList<>();

        //정점의 수만큼 ArrayList를 넣어준다.
        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        //노드 정보 입력
        for(int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        //dfs 호출 1부터 시작
        dfs(1);

        //출력
        StringBuilder sb = new StringBuilder();

        //2번 노드부터
        for(int i = 2; i < N + 1; i++) {
            sb.append(arr[i] + "\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void dfs(int point) {
        visited[point] = true;

        for(int i = 0; i < graph.get(point).size(); i++) {
            int next = graph.get(point).get(i);

            if(!visited[next]) {
                //다음정점에 부모를 기록
                arr[next] = point;
                dfs(next);
            }
        }
    }
}
