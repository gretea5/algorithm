import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();

        //개수 기록
        for(int element : tangerine) {
            map.put(element, map.getOrDefault(element, 0) + 1);
        }

        //key를 value 내림차순으로 정렬
        ArrayList<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (o1, o2) -> map.get(o2) - map.get(o1));

        int answer = 0;

        //종류 계산
        for(int key : keySet) {
            k -= map.get(key);
            answer += 1;
            if(k <= 0) {
                break;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int k = 3;
        int[] t = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solution(k, t));
    }
}
