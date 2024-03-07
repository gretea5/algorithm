import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        HashSet<Integer> set = new HashSet<>();

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            String command = st.nextToken();

            if(command.equals("all")) {
                set.clear();

                for(int i = 1; i <= 20; i++) {
                    set.add(i);
                }
            }
            else if(command.equals("empty")) {
                set.clear();
            }
            else if(command.equals("add")) {
                set.add(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("remove")) {
                set.remove(Integer.parseInt(st.nextToken()));
            }
            else if(command.equals("check")) {
                sb.append(set.contains(Integer.parseInt(st.nextToken())) ? 1 : 0).append("\n");
            }
            else {
                int x = Integer.parseInt(st.nextToken());
                if(set.contains(x)) {
                    set.remove(x);
                }
                else {
                    set.add(x);
                }
            }
        }

        System.out.print(sb);

        br.close();
    }
}
