import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringBuilder sb = new StringBuilder();
		
		for (int testCase = 1; testCase <= 10; testCase++) {
			sb.append("#").append(testCase).append(" ");
			
			int n = Integer.parseInt(br.readLine());
			
			LinkedList<Integer> list = new LinkedList<>();
			
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < n; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			int m = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for (int i = 0; i < m; i++) {
				String command = st.nextToken();
				
				if (command.equals("I")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					for (int j = 0; j < y; j++) {
						list.add(x + j, Integer.parseInt(st.nextToken()));
					}
				}
				else if (command.equals("D")) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					
					for (int j = 0; j < y; j++) {
						list.remove(x);
					}
				}
				else {
					int y = Integer.parseInt(st.nextToken()); 
					
					for (int j = 0; j < y; j++) {
						list.add(Integer.parseInt(st.nextToken()));
					}
				}
			}
			
			for (int i = 0; i < 10; i++) {
				sb.append(list.get(i)).append(" ");
			}
			
			sb.append("\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
	
}
