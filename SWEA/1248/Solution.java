import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Solution {
    private static int v, e;

    private static int[] depth;
    private static boolean[] visited;
    private static int[][] parent;

    private static ArrayList<Integer>[] graph;

    private static final int ROOT = 1;
    private static final int MAX_DEPTH = 14;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= tc; test++) {
            sb.append("#").append(test).append(" ");

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            depth = new int[v + 1];
            visited = new boolean[v + 1];
            parent = new int[v + 1][MAX_DEPTH + 1];
            graph = new ArrayList[v + 1];

            for (int i = 0; i < v + 1; i++) {
                graph[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < e; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                //c에서 1번째 부모는 p
                parent[c][0] = p;

                //그래프 간선 정보 입력
                graph[p].add(c);
            }

            dfs(ROOT, 1);

            parent[ROOT][0] = ROOT;

            for (int i = 1; i < MAX_DEPTH + 1; i++) {
                for (int j = 1; j < v + 1; j++) {
                    parent[j][i] = parent[parent[j][i - 1]][i - 1];
                }
            }

            int lcaNumber = lca(n1, n2);

            int size = bfs(lcaNumber);

            sb.append(lcaNumber).append(" ").append(size);
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void dfs(int x, int d) {
        visited[x] = true;
        depth[x] = d;

        for (int next : graph[x]) {
            if (!visited[next]) {
                dfs(next, d + 1);
            }
        }
    }

    private static int lca(int n1, int n2) {
        //더 깊은 높이를 가지는 노드의 번호를 n1으로 넣음
        if (depth[n1] < depth[n2]) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }

        //높이를 맞춤
        for (int i = MAX_DEPTH; i >= 0; i--) {
            if (depth[n1] - depth[n2] >= (1 << i)) {
                n1 = parent[n1][i];
            }
        }

        //노드의 번호가 같다면 공통 조상
        if (n1 == n2) {
            return n1;
        }

        for (int i = MAX_DEPTH; i >= 0; i--) {
            //두개가 다르면 올라가서 최소 공통 조상을 찾음
            if (parent[n1][i] != parent[n2][i]) {
                n1 = parent[n1][i];
                n2 = parent[n2][i];
            }
        }

        return parent[n1][0];
    }

    private static int bfs(int x) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        visited = new boolean[v + 1];

        queue.addLast(x);
        visited[x] = true;

        int size = 0;

        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();

            size += 1;

            for (int next : graph[cur]) {
                if (!visited[next]) {
                    queue.addLast(next);
                    visited[next] = true;
                }
            }
        }

        return size;
    }
}
