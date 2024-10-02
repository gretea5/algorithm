import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayList<Integer> crane = new ArrayList<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for (int i = 0; i < n; i++) {
            crane.add(Integer.parseInt(st.nextToken()));
        }
        
        int m = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        ArrayList<Integer> box = new ArrayList<>();
        
        for (int i = 0; i < m; i++) {
            box.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(crane, Collections.reverseOrder());
        Collections.sort(box, Collections.reverseOrder());
        
        //수화물을 옮길 수 없을 경우,
        if (crane.get(0) < box.get(0)) {
            System.out.print(-1);
            return;
        }
        
        //수화물 움직임 여부
        boolean[] moved = new boolean[m];
        
        //크레인의 이전 위치
        int[] position = new int[n];
        
        //수화물 움직인 횟수
        int movedCount = 0;
        
        int answer = 0;
        
        //수화물이 모두 비어있지 않을 경우,
        while (movedCount != m) {
            
            //여기에서 크레인과 수화물을 비교해, 
            //크레인당 해당되는 수화물을 비교하면 되겠네,
            int startIdx = 0;
            
            for (int i = 0; i < n; i++) {
                if (movedCount == m) {
                    break;
                }
                
                //크레인의 이전 위치를 기록해서 그 다음을 보는 형식으로 최적화
                for(int j = position[i]; j < m; j++) {
                    if (moved[j]) continue;
                    
                    //크레인으로 옮길 수 있다면,
                    if (crane.get(i) >= box.get(j)) {
                        moved[j] = true;
                        
                        movedCount += 1;
                        
                        startIdx = j;
                        
                        break;
                    }
                    //옮길수없을 경우,
                    else {
                        position[i] += 1;
                    }
                }
            }
            
            answer += 1; 
        }
        
        //출력
        System.out.print(answer); 
        
        br.close();
    }
}
