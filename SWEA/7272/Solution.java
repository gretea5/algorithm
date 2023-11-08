import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
public class Solution {
    private static HashMap<Character, Integer> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        init();
        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            boolean flag = true;
            if(s1.length() != s2.length()) {
                flag = false;
            }
            else {
                for(int i = 0; i < s1.length(); i++) {
                    int v1 = map.get(s1.charAt(i));
                    int v2 = map.get(s2.charAt(i));
                    if(v1 != v2) {
                        flag = false;
                        break;
                    }
                }
            }
            sb.append("#").append(test).append(" ");
            if(flag) {
                sb.append("SAME").append("\n");
            }
            else {
                sb.append("DIFF").append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
    private static void init() {
        String s0 = "CEFGHIJKLMNSTUVWXYZ";
        String s1 = "ADOPQR";
        String s2 = "B";
        for(int i = 0; i < s0.length(); i++) {
            map.put(s0.charAt(i), 0);
        }
        for(int i = 0; i < s1.length(); i++) {
            map.put(s1.charAt(i), 1);
        }
        for(int i = 0; i < s2.length(); i++) {
            map.put(s2.charAt(i), 2);
        }
    }
}
