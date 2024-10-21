import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		PriorityQueue<Long> pq = new PriorityQueue<>();
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) {
			pq.add(Long.parseLong(st.nextToken()));
		}
		
		for (int i = 0; i < m; i++) {
			long v1 = pq.remove();
			long v2 = pq.remove();
			
			long s = v1 + v2;
			
			pq.add(s);
			pq.add(s);
		}
		
		long sum = 0;
		
		while (!pq.isEmpty()) {
			sum += pq.remove();
		}
		
		System.out.print(sum);
		
		br.close();
	}
}
