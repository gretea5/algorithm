import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.PriorityQueue;

class Solution {
	public static void main(String[] arg) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		for (int tc = 1; tc <= t; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			
			//왼쪽 우선순위 큐(내림 차순 정렬)
			PriorityQueue<Integer> leftPQ = new PriorityQueue<>((n1, n2) -> n2 - n1);
			
			//오른쪽 우선순위 큐(오름 차순 정렬)
			PriorityQueue<Integer> rightPQ = new PriorityQueue<>();
			
			//오른쪽 우선순위 큐에서 제일 작은 값이 중앙값이 되도록 설정
			rightPQ.add(a);
			
			int sum = 0;
			
			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine(), " ");
				
				for (int j = 0; j < 2; j++) {
					int v = Integer.parseInt(st.nextToken());
					
					//우선순위큐의 균형을 맞춤
					if (leftPQ.size() < rightPQ.size()) {
						leftPQ.add(v);
					}
					else {
						rightPQ.add(v);
					}
					
					//두 큐에서 제일 작은 값과 제일 큰 값을 비교했을때,제일 작은 값이 더 크면 swap 해줌 
					if (leftPQ.peek() > rightPQ.peek()) {
						int left = leftPQ.remove();
						int right = rightPQ.remove();
						
						int temp = left;
						left = right;
						right = temp;
						
						leftPQ.add(left);
						rightPQ.add(right);
					}
				}
				
				//중앙 값 더하기
				sum += (rightPQ.peek());
				sum %= 20171109;
			}
			
			//출력
			sb.append("#").append(tc).append(" ");
			sb.append(sum);
			sb.append("\n");
		}
		
		System.out.print(sb);
		
		br.close();
	}
}
