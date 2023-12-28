import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedHashSet;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.Arrays;
import java.util.Iterator;
public class Main {
    private static int N, M;
    private static boolean[] used;
    private static int[] arr;
    private static Set<String> set = new LinkedHashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        used = new boolean[N];
        st = new StringTokenizer(br.readLine()," ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backTrack("", 0, 0);
        Iterator<String> iter = set.iterator();
        while(iter.hasNext()) {
            sb.append(iter.next()).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private static void backTrack(String s, int length, int before) {
        if(length == M) {
            set.add(s.trim());
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!used[i] && before <= arr[i]) {
                used[i] = true;
                backTrack(s + " " + arr[i], length + 1, arr[i]);
                used[i] = false;
            }
        }
    }
}
