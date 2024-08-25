import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        char[] arr1 = br.readLine().toCharArray();
        char[] arr2 = br.readLine().toCharArray();
        
        int[][] dp = new int[arr1.length + 1][arr2.length + 1];
        
        for (int i = 1; i <= arr1.length; i++) {
            for (int j = 1; j <= arr2.length; j++) {
                //문자가 같으면 1을 붙임
                if (arr1[i - 1] == arr2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                //문자가 다르면, 둘중에 하나를 안붙인 길이중에 큰 길이를 넣어줌
                else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        sb.append(dp[arr1.length][arr2.length]).append("\n");
        
        ArrayDeque<Character> stack = new ArrayDeque<>();
        
        int i = arr1.length;
        int j = arr2.length;
        
        while(true) {
            if (i == 0 || j == 0) break;
            
            //LCS 길이가 같으면 달라지는 부분까지 열과 행을 움직임
            if (dp[i][j] == dp[i][j - 1]) {
                j -= 1;
            }
            else if (dp[i][j] == dp[i - 1][j]) {
                i -= 1;
            }
            //끝 부분에 왔을때, 즉 길이가 달라진 부분은 문자를 붙였다고 할 수 있음
            else {
                stack.addFirst(arr1[i - 1]);
                
                i -= 1;
                j -= 1;
            }
        }
        
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst());
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
