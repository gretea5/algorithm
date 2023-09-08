import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static boolean[] visited;
    private static int[] arr;
    private static int LENGTH;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        LENGTH = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }
        backTrack("", 0, -1);
        br.close();
    }
    private static void backTrack(String s, int length, int before) {
        if(length == LENGTH) {
            System.out.println(s.trim());
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!visited[i] && before < arr[i]) {
                visited[i] = true;
                backTrack(s + " " + arr[i], length + 1, arr[i]);
                visited[i] = false;
            }
        }
    }
}
