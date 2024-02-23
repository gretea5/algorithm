import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];

        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int type = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(type == 0) {
                union(a, b);
            }
            else {
                if(find(a) == find(b)) {
                    sb.append("YES").append("\n");
                }
                else {
                    sb.append("NO").append("\n");
                }
            }
        }

        System.out.print(sb);

        br.close();
    }

    //부서장을 찾는 연산 그리고 찾으면서 갱신을 시켜준다.
    private static int find(int a) {
        if(parent[a] == a) return a;

        //찾아가면서, 갱신을 시켜준다.
        parent[a] = find(parent[a]);

        return parent[a];
    }

    //a, b의 부서장을 찾고 부서장끼리 갱신해준다.
    private static void union(int a, int b) {
        //각각 부서장 찾기
        int x = find(a);
        int y = find(b);

        //부서장 갱신
        parent[x] = y;
    }
}
