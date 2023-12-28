import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer; 
import java.util.TreeMap;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        TreeMap<String, String> nameToGroup = new TreeMap<>();
        for(int k = 0; k < N; k++) {
            String group = br.readLine();
            int memberCnt = Integer.parseInt(br.readLine());
            for(int i = 0; i < memberCnt; i++) {
                String name = br.readLine();
                nameToGroup.put(name, group);
            }
        }
        for(int k = 0; k < M; k++) {
            String str = br.readLine();
            int type = Integer.parseInt(br.readLine());
            if (type == 1) {
                sb.append(nameToGroup.get(str)).append("\n");
            }
            else {
                for(String name : nameToGroup.keySet()) {
                    String group = nameToGroup.get(name);
                    if (group.equals(str)) {
                        sb.append(name).append("\n");
                    }
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}
