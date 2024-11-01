import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.ArrayList;


public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int test = 1; test <= t; test++) {
			int n = Integer.parseInt(br.readLine());
			
			HashSet<String> set = new HashSet<>();
			
			for (int i = 0; i < n; i++) {
				set.add(br.readLine());
			}
			
			ArrayList<String> list = new ArrayList<>(set);
			
			list.sort((s1, s2) -> {
				if (s1.length() == s2.length()) {
					return s1.compareTo(s2);
				}
				
				return s1.length() - s2.length();
			});
			
			sb.append("#").append(test).append("\n");
			
			for (String s : list) {
				sb.append(s).append("\n");
			}
		}
		
		System.out.print(sb);
		
		br.close();
	}
}
