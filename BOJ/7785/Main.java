import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeSet;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        TreeSet<String> set = new TreeSet<>(Collections.reverseOrder());
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            String command = st.nextToken();
            if(command.equals("enter")) {
                set.add(name);
            }
            else {
                set.remove(name);
            }
        }
        for(String value: set) {
            sb.append(value).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
