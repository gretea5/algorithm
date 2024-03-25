import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static final int INF = 1000_0001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        int[][] dist = new int[n + 1][n + 1];

        for(int i = 0; i < n + 1; i++) {
            for(int j = 0; j < n + 1; j++) {
                if (i != j) {
                    dist[i][j] = INF;
                }
                else {
                    dist[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            dist[a][b] = Math.min(dist[a][b], c);
        }

        for(int k = 1; k <= n; k++) {
            for(int i = 1; i <= n; i++) {
                for(int j = 1; j <= n; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) {
                    sb.append(0).append(" ");
                }
                else {
                    sb.append(dist[i][j]).append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
