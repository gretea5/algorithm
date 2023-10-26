import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Solution {
    private static char[] arr;
    private static int swapCount;
    private static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int test = 1; test <= T; test++) {
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            arr = st.nextToken().toCharArray();
            swapCount = Integer.parseInt(st.nextToken());
            max = Integer.MIN_VALUE;
            dfs(0, 0);
            sb.append("#").append(test).append(" ").append(max).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
    private static void dfs(int start, int count) {
        //바꾸는 횟수를 다 썼다면,
        if(count == swapCount) {
            StringBuilder sb = new StringBuilder();
            for(char c: arr) {
                sb.append(c);
            }
            //최댓값 갱신
            max = Math.max(max, Integer.parseInt(sb.toString()));
            return;
        }
        for(int i = start; i < arr.length; i++) {
            for(int j = i + 1; j < arr.length; j++) {
                //배열의 값을 바꾼다.
                char temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                //재귀 호출
                dfs(i, count + 1);
                //다시 원래대로 복귀
                temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

