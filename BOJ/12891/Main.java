import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    private static int[] check;
    private static int[] cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        char[] arr = br.readLine().toCharArray();
        check = new int[4];
        st = new StringTokenizer(br.readLine(), " ");
        check[0] = Integer.parseInt(st.nextToken());
        check[1] = Integer.parseInt(st.nextToken());
        check[2] = Integer.parseInt(st.nextToken());
        check[3] = Integer.parseInt(st.nextToken());
        cnt = new int[4];
        for(int i = 0; i < P; i++) {
            if(arr[i] == 'A') cnt[0]++;
            else if(arr[i] == 'C') cnt[1]++;
            else if(arr[i] == 'G') cnt[2]++;
            else if(arr[i] == 'T') cnt[3]++;
        }
        int answer = 0;
        if(check()) answer++;
        for(int j = P; j < S; j++) {
            int i = j - P;
            if(arr[i] == 'A') cnt[0]--;
            else if(arr[i] == 'C') cnt[1]--;
            else if(arr[i] == 'G') cnt[2]--;
            else if(arr[i] == 'T') cnt[3]--;

            if(arr[j] == 'A') cnt[0]++;
            else if(arr[j] == 'C') cnt[1]++;
            else if(arr[j] == 'G') cnt[2]++;
            else if(arr[j] == 'T') cnt[3]++;

            if(check()) {
                answer++;
            }
        }
        System.out.print(answer);
        br.close();
    }
    private static boolean check() {
        for(int i = 0; i < 4; i++) {
            if(check[i] > cnt[i]) {
                return false;
            }
        }
        return true;
    }
}
