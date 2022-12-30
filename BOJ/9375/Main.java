import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.HashMap;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int k = 0; k < T; k++) {
            HashMap<String, Integer> hm = new HashMap<>();
            int n = Integer.parseInt(br.readLine());
            for(int h = 0; h < n; h++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");
                st.nextToken();
                String key = st.nextToken();
                if(hm.containsKey(key)) {
                    hm.put(key, hm.get(key) + 1);
                } else {
                    hm.put(key, 1);
                }
            }
            int answer = 1;
            for(int value : hm.values()) {
                answer *= (value + 1);
            }
            System.out.println(answer - 1);
        }
        br.close();
    }
}
