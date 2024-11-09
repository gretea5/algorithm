import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
    private static ArrayList<Integer>[] toChild;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCase = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= testCase; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            //정점 간선의 개수 정보
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            //시작 정점 2개
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            toChild = new ArrayList[v + 1];
            int[] toParent = new int[v + 1];

            for (int i = 0; i < v + 1; i++) {
                toChild[i] = new ArrayList<>();
            }

            st = new StringTokenizer(br.readLine(), " ");

            for (int i = 0; i < e; i++) {
                int p = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                toChild[p].add(c);
                toParent[c] = p;
            }

            //부모로 이동하는 정점
            int cur1 = n1;
            int cur2 = n2;

            HashSet<Integer> set1 = new HashSet<>();
            HashSet<Integer> set2 = new HashSet<>();

            //가장 가까운 공통 조상
            int nearParent = 0;

            while(true) {
                int parent1 = toParent[cur1];

                //가장 가까운 공통 조상을 찾았을 경우
                if (set2.contains(parent1)) {
                    nearParent = parent1;
                    break;
                }
                //parent1이 집합에 포함되어 있지 않다면,
                else {
                    set1.add(parent1);
                    cur1 = parent1;
                }

                int parent2 = toParent[cur2];

                //가장 가까운 공통 조상을 찾았을 경우
                if (set1.contains(parent2)) {
                    nearParent = parent2;
                    break;
                }
                //parent2이 집합에 포함되어 있지 않다면, 넣고 부모로 이동
                else {
                    set2.add(parent2);
                    cur2 = parent2;
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(nearParent).append(" ").append(bfs(nearParent));
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    //가장 가까운 공통 조상으로부터 크기를 구함
    private static int bfs(int start) {
        boolean[] visited = new boolean[toChild.length];
        ArrayDeque<Integer> queue = new ArrayDeque<>();

        queue.addLast(start);
        visited[start] = true;

        int size = 0;

        while (!queue.isEmpty()) {
            int cur = queue.removeFirst();

            size += 1;

            for (int next : toChild[cur]) {
                if (!visited[next]) {
                    queue.addLast(next);
                    visited[next] = true;
                }
            }
        }

        return size;
    }
}
