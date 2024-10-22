import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int s = Integer.parseInt(st.nextToken());
		
		int[] dist = new int[n];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) {
			int d = Integer.parseInt(st.nextToken());
			
			dist[i] = Math.abs(d - s);
		}
		
		int answer = dist[0];
		
		for (int i = 1; i < n; i++) {
			answer = gcd(answer, dist[i]);
		}
		
		System.out.print(answer);
		
		br.close();
	}
	
	private static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		
		return a;
	}
}
