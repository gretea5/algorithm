import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashMap<Character, Character> map = new HashMap<>();
		
		map.put('I', 'E');
		map.put('E', 'I');
		
		map.put('S', 'N');
		map.put('N', 'S');
		
		map.put('T', 'F');
		map.put('F', 'T');
		
		map.put('J', 'P');
		map.put('P', 'J');
		
		StringBuilder sb = new StringBuilder();
		
		for (char ch : br.readLine().toCharArray()) {
			sb.append(map.get(ch));
		}
		
		System.out.print(sb);
		
		br.close();
	}
}
