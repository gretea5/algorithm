import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
import java.util.ArrayList;
public class Main {
    private static int N, K, length;
    private static HashSet<Integer> set;
    private static ArrayList<Integer> arr;
    private static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        length = String.valueOf(N).length();
        set = new HashSet<>();
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < K; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        arr = new ArrayList<>(set);
        answer = 0;
        backTrack("", 0);
        System.out.print(answer);
        br.close();
    }
    private static void backTrack(String s, int len) {
        if(len > length) {
            return;
        }
        if(!s.isEmpty()) {
            if (N >= Integer.parseInt(s.trim())) {
                answer = Math.max(answer, Integer.parseInt(s.trim()));
            }
        }
        for(int i = 0; i < arr.size(); i++) {
            backTrack(s + arr.get(i), len + 1);
        }
    }
}
