import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
    private static StringBuilder sb = new StringBuilder();
    private static int N, M;
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        backTrack("", 0, 0);
        System.out.print(sb);
        br.close();
    }
    private static void backTrack(String s, int length, int before) {
        if(length == M) {
            sb.append(s.trim()).append("\n");
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(before <= arr[i]) {
                backTrack(s + " " + arr[i], length + 1, arr[i]);
            }
        }
    }
}
