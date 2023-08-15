import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Arrays;
public class Main {
    private static boolean[] visited;
    private static int F, S, G, U, D;
    private static int[] distance;
    private static int[] move;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        visited = new boolean[F + 1];
        distance = new int[F + 1];
        Arrays.fill(distance, -1);
        move = new int[] {U, (D * -1)};
        System.out.print(bfs(S));
        br.close();
    }
    private static String bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.addLast(start);
        distance[start] = 0;
        visited[start] = true;
        while(!queue.isEmpty()) {
            int cur = queue.removeFirst();
            for(int i = 0; i < move.length; i++) {
                int m = cur + move[i];
                if (m < 1 || m > F) {
                    continue;
                }
                if(!visited[m]) {
                    queue.addLast(m);
                    distance[m] = distance[cur] + 1;
                    visited[m] = true;
                }
            }
        }
        if(distance[G] == -1) {
            return "use the stairs";
        }
        return String.valueOf(distance[G]);
    }
}
