import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int[] arr;
    private static int LENGTH;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        LENGTH = Integer.parseInt(st.nextToken());
        arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        backTrack("", 0);
        System.out.print(sb);
        br.close();
    }
    private static void backTrack(String s, int length) {
        if(length == LENGTH) {
            sb.append(s.trim()).append("\n");
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            backTrack(s + " " + arr[i], length + 1);
        }
    }
}
