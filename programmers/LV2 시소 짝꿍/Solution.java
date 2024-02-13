import java.util.Arrays;
import java.util.HashMap;

class Solution {
    public long solution(int[] weights) {
        long answer = 0;
        
        //오름 차순 정렬을 해서 다음 수가 크다는 것을 보장
        Arrays.sort(weights);
        
        HashMap<Double, Integer> map = new HashMap<>();
        
        for(int w : weights) {
            //자기 자신보다 비율로 작은 무게를 따짐(1:1, 2:3, 1:2, 3:4)
            double a = w * 1.0;
            double b = (w * 2.0) / 3.0;
            double c = (w * 1.0) / 2.0;
            double d = (w * 3.0) / 4.0;
            
            //자기 자신보다 비율이 낮은 무게가 존재하면 쌍의 갯수를 구한다.
            if(map.containsKey(a)) answer += map.get(a);
            if(map.containsKey(b)) answer += map.get(b);
            if(map.containsKey(c)) answer += map.get(c);
            if(map.containsKey(d)) answer += map.get(d);
            
            //무게의 개수를 기록
            map.put((w * 1.0), map.getOrDefault((w * 1.0), 0) + 1);
        }
        
        return answer;
    }
}
