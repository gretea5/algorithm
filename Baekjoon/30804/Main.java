import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] fruits = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < n; i++) {
            fruits[i] = Integer.parseInt(st.nextToken());
        }
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        int left = 0;
        int right = 0;
        
        int answer = Integer.MIN_VALUE;
        
        while(right < n) {
            int rightFruit = fruits[right];
            //개수를 기록
            map.put(rightFruit, map.getOrDefault(rightFruit, 0) + 1);
            
            //2개 이상의 종류가 담기면 left를 이동해본다.
            while(map.keySet().size() > 2 && left < n) {
                int leftFruit = fruits[left];
                int cnt = map.get(leftFruit);
                
                map.put(leftFruit, cnt - 1);
                
                if (cnt == 1) {
                    map.remove(leftFruit);
                }
                
                left += 1;
            }
            
            answer = Math.max(answer, right - left + 1);
            
            right += 1;
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
