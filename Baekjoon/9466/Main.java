import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static int n, count;
    private static int[] arr;
    private static boolean[] visited;
    private static boolean[] done;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t = 0; t < T; t++) {
            n = Integer.parseInt(br.readLine());
            arr = new int[n + 1];
            visited = new boolean[n + 1];
            done = new boolean[n + 1];
            count = 0;
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int i = 1; i <= n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for(int i = 1; i <= n; i++) {
                if(!done[i]){
                    dfs(i);
                }
            }
            sb.append(n - count).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private static void dfs(int now) {
        if(visited[now]) {
            done[now] = true;
            count += 1;
        }
        else {
            visited[now] = true;
        }
        int next = arr[now];
        if(!done[next]) {
            dfs(next);
        }
        //지목한 사람이 팀 결성이 되었을 경우,
        visited[now] = false;
        done[now] = true;
    }
}
