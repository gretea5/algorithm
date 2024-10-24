import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
	private static int[] parentPos;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int g = Integer.parseInt(br.readLine());
		int p = Integer.parseInt(br.readLine());
		
		parentPos = new int[g + 1];
		
		for (int i = 0; i < g + 1; i++) {
			parentPos[i] = i;
		}
		
		int answer = 0;
		
		for (int i = 0; i < p; i++) {
			//최대 비행기의 게이트
			int maxPlanePos = Integer.parseInt(br.readLine());
			
			//최대 비행기의 게이트에 해당하는 둘 수 있는 게이트
			int pos = find(maxPlanePos);
			
			//비행기가 둘 수 있는 게이트가 0이면 끝
			if (pos == 0) {
				break;
			}
			
			answer += 1;
			
			//pos에 비행기를 두었으면, pos - 1의 위치랑 같은 묶음으로 불려야함
			union(pos, pos - 1);
		}
		
		System.out.print(answer);
		
		br.close();
	}
	
	//x게이트에 해당하는 둘 수 있는 위치를 반환
	private static int find(int x) {
		if (x == parentPos[x]) 
			return x;
		
		parentPos[x] = find(parentPos[x]);
		
		return parentPos[x];
	}
	
	//집합을 합치는 연산
	private static void union(int x, int y) {
		int p1 = find(x);
		int p2 = find(y);
		
		parentPos[p1] = p2;
	}
}
