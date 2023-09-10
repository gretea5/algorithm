import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static int SELECTNUMBER = 6;
    private static int k;
    private static StringBuilder sb = new StringBuilder();
    private static int[] arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            k = Integer.parseInt(st.nextToken());
            if(k == 0) break;
            arr = new int[k];
            for(int i = 0; i < k; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            backTrack("", 0,0);
            sb.append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private static void backTrack(String s, int length, int before) {
        if(length == SELECTNUMBER) {
            sb.append(s.trim()).append("\n");
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(before < arr[i]) {
                backTrack(s + " " + arr[i], length + 1, arr[i]);
            }
        }
    }
}
