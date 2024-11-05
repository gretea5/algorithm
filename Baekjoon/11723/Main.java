import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int m = Integer.parseInt(br.readLine());
		
		int total = 0;
		
		StringBuilder sb = new StringBuilder();
		
		while (m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			String command = st.nextToken();
			
			if ("add".equals(command)) {
				int x = Integer.parseInt(st.nextToken());
				
				total = (total | (1 << (x - 1)));
			}
			else if ("remove".equals(command)) {
				int x = Integer.parseInt(st.nextToken());
				
				total = (total & ~(1 << (x - 1)));
			}
			else if ("check".equals(command)) {
				int x = Integer.parseInt(st.nextToken());
				
				sb.append((total & (1 << (x - 1))) != 0 ? 1 : 0).append("\n");
			}
			else if ("toggle".equals(command)) {
				int x = Integer.parseInt(st.nextToken());
				
				total = ((1 << (x - 1)) ^ total);
			}
			else if ("all".equals(command)) {
				total = (1 << 20) - 1;
			}
			else {
				total = 0;
			}
			
			m -= 1;
		}
		
		System.out.println(sb);
		
		br.close();
	}
}
