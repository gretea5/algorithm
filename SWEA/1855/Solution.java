import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

class Solution {
    private static int[] depth;
    private static int[][] parent;
    private static ArrayList<Integer>[] graph;
    private static ArrayList<Integer> bfsSearchNodeList;

    private static int n;
    private static final int MAX_DEPTH = 17;
    private static final int START_POINT = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            n = Integer.parseInt(br.readLine());

            init();

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for (int i = 2; i < n + 1; i++) {
                int child = i;
                int parent = Integer.parseInt(st.nextToken());

                graph[parent].add(child);
            }

            bfs(START_POINT);

            //부모 노드 희소테이블(선행 정점을 빠르게 찾기 위한 자료구조) 초기화
            setParentNode();

            //10만 * 10만 연산 생각
            long answer = 0;

            for (int i = 0; i < bfsSearchNodeList.size() - 1; i++) {
                //bfs의 정점
                int p1 = bfsSearchNodeList.get(i);
                int p2 = bfsSearchNodeList.get(i + 1);

                //공통 조상 찾기
                int lcaPoint = lca(p1, p2);

                //깊이 값 차이만큼 더함
                answer += (depth[p1] - depth[lcaPoint]);
                answer += (depth[p2] - depth[lcaPoint]);
            }

            //출력
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }


    /* 배열 초기화 함수 */
    private static void init() {
        //깊이 기록 배열
        depth = new int[n + 1];

        //parent[node][MAX_DEPTH] => node로부터 2^(MAX_DEPTH) 번째 상위에 있는 정점
        parent = new int[n + 1][MAX_DEPTH + 1];

        bfsSearchNodeList = new ArrayList<>();

        graph = new ArrayList[n + 1];

        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
    }

    private static void bfs(int x) {
        boolean[] visited = new boolean[n + 1];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        //시작 정점
        queue.addLast(x);
        visited[x] = true;

        int curDepth = 1;

        //시작 정점 깊이 값 기록
        depth[x] = curDepth;

        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();

            //bfs의 노드 방문 순서를 담음(중요!!)
            bfsSearchNodeList.add(cur);

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    //큐에넣기
                    queue.addLast(next);

                    //방문 처리
                    visited[next] = true;

                    //next로 부터 2^0번째 즉 바로 위의 부모를 기록
                    parent[next][0] = cur;

                    depth[next] = depth[cur] + 1;
                }
            }
        }
    }

    //parent[i][j] : i에서 2^j번째 조상인 배열을 초기화하는 로직(2^2 => 2 + 2, 2^3 => 4 + 4)
    private static void setParentNode() {
        for (int i = 1; i < MAX_DEPTH; i++) {
            for (int j = 2; j < n + 1; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];
            }
        }
    }

    private static int lca(int x1, int x2) {
        //x2가 깊이가 더 깊으면 바꿈,
        if (depth[x1] < depth[x2]) {
            int temp = x1;
            x1 = x2;
            x2 = temp;
        }

        //최대 깊이부터 가면서 길이차이가 2^i제곱 꼴보다 크면 바로 x1를 갱신해줌(깊이 맞추기)
        for (int i = MAX_DEPTH; i >= 0; i--) {
            if (depth[x1] - depth[x2] >= (1 << i)) {
                x1 = parent[x1][i];
            }
        }

        //노드가 같다면 최소 공통 조상
        if (x1 == x2) {
            return x1;
        }

        //공통 조상이 다르다면, 부모로 올리고 다시 그 사이에서 최소 공통 조상을 찾는다.
        for (int i = MAX_DEPTH; i >= 0; i--) {
            if (parent[x1][i] != parent[x2][i]) {
                x1 = parent[x1][i];
                x2 = parent[x2][i];
            }
        }

        //그러면 x1, x2는 최소 공통 조상에서 바로 밑 노드가 된다. 그래서 2^0번째 바로 위 부모 노드를 반환
        return parent[x1][0];
    }
}
