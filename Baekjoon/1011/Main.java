import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int distance = Math.abs(Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken()));

            int rootValue = (int) Math.sqrt(distance);

            if(distance == rootValue * rootValue) {
                sb.append((rootValue * 2) - 1).append("\n");
            }
            else if(distance <= (rootValue * rootValue) + rootValue) {
                sb.append(rootValue * 2).append("\n");
            }
            else {
                sb.append((rootValue * 2) + 1).append("\n");
            }
        }

        System.out.print(sb);

        br.close();
    }
}
