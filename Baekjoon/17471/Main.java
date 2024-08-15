import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
    private static int n;
    private static int min;

    private static int[] arr;
    private static boolean[] visited;

    private static HashSet<Integer> selectedSet;
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        //인접 리스트에 정보를 넣어줌
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int number = Integer.parseInt(st.nextToken());

            for (int j = 0; j < number; j++) {
                int from = i;
                int to = Integer.parseInt(st.nextToken()) - 1;

                graph[from].add(to);
                graph[to].add(from);
            }
        }

        selectedSet = new HashSet<>();

        min = Integer.MAX_VALUE;

        //1개는 선택되어서 시작해야하기 때문에, for문을 돌면서 시작
        for(int i = 0; i < n; i++) {
            selectedSet.add(i);

            backTrack(i + 1, 1);

            selectedSet.remove(i);
        }

        //min이 갱신이 되지 않았다면 -1
        if (min == Integer.MAX_VALUE) {
            System.out.print(-1);
            return;
        }

        System.out.print(min);

        br.close();
    }

    private static void backTrack(int idx, int depth) {
        if (depth == n) {
            return;
        }

        //방문 배열 초기화
        visited = new boolean[n];

        //선택된 영역의 시작이 어디서 되든 같은 영역은 방문처리가 된다.(1번 수행)
        for (int i = 0; i < n; i++) {
            if (!visited[i] && selectedSet.contains(i)) {
                selectedDfs(i);
                break;
            }
        }

        //선택되지 않은 영역의 시작이 어디서 되든 같은 영역은 방문처리가 된다.(1번 수행)
        for (int i = 0; i < n; i++) {
            if (!visited[i] && !selectedSet.contains(i)) {
                unSelectedDfs(i);
                break;
            }
        }

        //모두 방문이 되었다면,구로 잘 나누어 졌다는 것,
        if (check()) {
            int selectedSum = 0;
            int unSelectedSum = 0;

            for (int i = 0; i < n; i++) {
                if (selectedSet.contains(i)) {
                    selectedSum += arr[i];
                }
                else {
                    unSelectedSum += arr[i];
                }
            }

            min = Math.min(min, Math.abs(selectedSum - unSelectedSum));
        }

        //선택이 되고 안되고를 따져야함.
        for (int i = idx; i < n; i++) {
            selectedSet.add(i);

            backTrack(i + 1, depth + 1);

            selectedSet.remove(i);
        }
    }

    //모든 정점이 방문이 되었는지 여부
    private static boolean check() {
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                return false;
            }
        }

        return true;
    }

    //선택된 정점을 dfs
    private static void selectedDfs(int start) {
        visited[start] = true;

        for(int next : graph[start]) {
            if (!visited[next] && selectedSet.contains(next)) {
                selectedDfs(next);
            }
        }
    }

    //선택되지 않은 정점을 dfs
    private static void unSelectedDfs(int start) {
        visited[start] = true;

        for(int next : graph[start]) {
            if (!visited[next] && !selectedSet.contains(next)) {
                unSelectedDfs(next);
            }
        }
    }
}
