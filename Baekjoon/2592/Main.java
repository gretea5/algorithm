import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < 10; i++) {
            int v = Integer.parseInt(br.readLine());
            
            map.put(v, map.getOrDefault(v, 0) + 1);
        }
        
        //최빈값
        int num = 0;
        
        //최대 빈도 수
        int max = Integer.MIN_VALUE;
        
        //점수 총합
        int sum = 0;
    
        for(int key : map.keySet()) {
            //빈도 수
            int v = map.get(key);
            
            //최빈값 기록
            if (max < v) {
                max = v;
                num = key;
            }
            
            //합 기록
            sum += (key * v);
        }
        
        //평균
        System.out.println(sum / 10);
        //최빈값
        System.out.print(num);
        
        br.close();
    }
}
