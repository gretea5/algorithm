import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashSet<String> notListen = new HashSet<>();
        HashSet<String> notSee = new HashSet<>();
        ArrayList<String> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            notListen.add(br.readLine());
        }
        for(int i = 0; i < M; i++) {
            notSee.add(br.readLine());
        }
        for(String s : notListen) {
            if (notSee.contains(s) && notListen.contains(s)) {
                list.add(s);
            }
        }
        Collections.sort(list);
        sb.append(list.size()).append("\n");
        for(String s : list) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
