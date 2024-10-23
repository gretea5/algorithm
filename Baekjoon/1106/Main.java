import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
	private static final int ADD_LENGTH = 101;
	private static final int MAX = 987654321;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int c = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		//dp[i] = i명의 고객의 수를 투자해야하는 금액의 최솟값
		int[] dp = new int[c + ADD_LENGTH];
		
		Arrays.fill(dp, MAX);
		
		dp[0] = 0;
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int cost = Integer.parseInt(st.nextToken());
			int person = Integer.parseInt(st.nextToken());
			
			for (int j = person; j < c + ADD_LENGTH; j++) {
				dp[j] = Math.min(dp[j], dp[j - person] + cost);
			}
		}
		
		int answer = MAX;
		
		for (int i = c; i < c + ADD_LENGTH; i++) {
			answer = Math.min(dp[i], answer);
		}
		
		System.out.print(answer);
	
		br.close();
	}
}
