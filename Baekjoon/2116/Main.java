import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;

public class Main {
    private static HashMap<Integer, Integer> map;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        initMap();
        
        int n = Integer.parseInt(br.readLine());
        
        int[][] dice = new int[n][6];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            for (int j = 0; j < 6; j++) {
                dice[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        int answer = Integer.MIN_VALUE;
        
        //0 ~ 5번에 해당하는 인덱스를 모두 아래로 했을 경우를 생각
        for (int i = 0; i < 6; i++) {
            int lowerIdx = i;
            int upperIdx = map.get(lowerIdx);
            
            int max = Integer.MIN_VALUE;
            
            for (int j = 0; j < 6; j++) {
                if (j != lowerIdx && j != upperIdx) {
                    max = Math.max(dice[0][j], max);
                }
            }
            
            //첫번째 주사위에서의 옆면에서의 최댓값
            int sum = max;
            
            //두번째 주사위 부터 쌓기
            for (int j = 1; j < n; j++) {
                //이전 주사위의 upper에 해당하는 값과 동일한 값에 대한 하단 인덱스를 찾기
                for (int k = 0; k < 6; k++) {
                    if (dice[j - 1][upperIdx] == dice[j][k]) {
                        lowerIdx = k;
                        break;
                    }
                }
                
                //상단 값 인덱스 찾기
                upperIdx = map.get(lowerIdx);
                
                max = Integer.MIN_VALUE;
                
                for (int k = 0; k < 6; k++) {
                    if (k != lowerIdx && k != upperIdx) {
                        max = Math.max(dice[j][k], max);
                    }
                }
                
                sum += max;
            }
            
            answer = Math.max(answer, sum);
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void initMap() {
        map = new HashMap<>();
        
        map.put(0, 5);
        map.put(1, 3);
        map.put(2, 4);
        map.put(3, 1);
        map.put(4 ,2);
        map.put(5, 0); 
    }
}
