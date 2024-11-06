import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int testCase = 1; testCase <= t; testCase++) {
            sb.append("#").append(testCase).append(" ");
            
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine(), " ");

            ArrayList<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                list.add(Integer.parseInt(st.nextToken()));
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine(), " ");

                String command = st.nextToken();

                if (command.equals("I")) {
                    int idx = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());

                    list.add(idx, value);
                }
                else if (command.equals("D")) {
                    int idx = Integer.parseInt(st.nextToken());

                    list.remove(idx);
                }
                else {
                    int idx = Integer.parseInt(st.nextToken());
                    int value = Integer.parseInt(st.nextToken());

                    list.set(idx, value);
                }
            }

            if (l < list.size()) {
                sb.append(list.get(l));
            }
            else {
                sb.append(-1);
            }

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
