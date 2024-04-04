import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        ArrayList<Integer> cList = new ArrayList<>();
        
        for(int i = 0; i < N; i++) {
            cList.add(Integer.parseInt(st.nextToken()));
        }
        
        int M = Integer.parseInt(br.readLine());
        
        st = new StringTokenizer(br.readLine(), " ");
        
        ArrayList<Integer> bList = new ArrayList<>();
        
        for(int i = 0; i < M; i++) {
            bList.add(Integer.parseInt(st.nextToken()));
        }
        
        Collections.sort(cList, Collections.reverseOrder());
        Collections.sort(bList, Collections.reverseOrder());
        
        if (cList.get(0) < bList.get(0)) {
            System.out.print(-1);
            return;
        }
        
        int time = 0;
        
        //박스에 담은 상자가 비어 있지 않을 동안,
        while(!bList.isEmpty()) {
            //크레인 인덱스, 박스 인덱스
            int cIdx = 0;
            int bIdx = 0;
            
            //즉 둘다 size까지 않았을 동안,
            while(cIdx != cList.size() && bIdx != bList.size()) {
                //크레인에서 당겨올 수 있는 경우,
                if (cList.get(cIdx) >= bList.get(bIdx)) {
                    //박스에 있는 bIdx 인덱스에 해당하는 값 제거
                    bList.remove(bIdx);
                    
                    //여기서 +1을 크레인을 해줘야한다 why? => 박스에 있는 bIdx를 1더해주는 순간 데이터가 스킵되어버린다.
                    //ArrayList에서 삭제하면 앞으로 이동하는 연산 때문에, bIdx는 이동을 하면 안된다.
                    //그리고 크레인 입장에서는, 다음 크레인에서 박스의 무게랑 비교를 해야한다.
                    cIdx += 1;
                    
                }
                //크레인에서 못당겨오는 경우 박스의 인덱스 값을 증가
                else {
                    bIdx += 1;
                }
            }
            
            time += 1;
        }
        
        System.out.print(time);
        
        br.close();
    }
}
