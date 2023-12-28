import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map <Integer, Integer> map = new HashMap<>();
        int answer = 0;
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());
            if (!map.containsKey(num)) {
                map.put(num, position);
            }
            else {
                int p = map.get(num);
                if (position != p) {
                    map.put(num, position);
                    answer++;
                }
            }
        }
        System.out.print(answer);
        br.close();
    }
}
