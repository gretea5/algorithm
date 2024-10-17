import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> cranes = new ArrayList<>();
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < n; i++) {
			cranes.add(Integer.parseInt(st.nextToken()));
		}
		
		int m = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> boxes = new ArrayList<>(); 
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for (int i = 0; i < m; i++) {
			boxes.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(cranes, Collections.reverseOrder());
		Collections.sort(boxes, Collections.reverseOrder());
		
		if (cranes.get(0) < boxes.get(0)) {
			System.out.print(-1);
			return;
		}
		
		int[] pos = new int[n];
		boolean[] removed = new boolean[m];
		
		int answer = 0;
		int removeCount = 0;
		
		while(true) {
			if (removeCount == m) {
				break;
			}
			
			for (int i = 0; i < n; i++) {
				//하나의 포크레인에 대해서, 자기자신보다 같거나 작으면 바로 스톱
				for (int j = pos[i]; j < m; j++) {
					//삭제 처리가 되었다면, continue;
					if (removed[j]) {
						//크레인 위치 이동
						pos[i] += 1;
						
						continue;
					}
					
					if (cranes.get(i) >= boxes.get(j)) {
						//삭제 처리를 하고
						removed[j] = true;
						
						removeCount += 1;
						
						break;
					}
					
					//들 수 없으면 이동해버림
					pos[i] += 1;
				}
			}
			
			answer += 1; 
		}
		
		System.out.print(answer);

		br.close();
	}

}
