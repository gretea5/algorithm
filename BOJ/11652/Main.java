import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Long, Integer> map = new HashMap<>();
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; i++) {
            //입력받는 카드
            long key = Long.parseLong(br.readLine());
            //입력
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        long answer = 0;
        //key를 담고있는 ArrayList
        ArrayList<Long> keyList = new ArrayList<>(map.keySet());
        //오름차순 정렬
        Collections.sort(keyList);
        //작은 값부터 차례대로 최댓값을 갱신해서 카드 값을 갱신
        for(long key : keyList) {
            if(max < map.get(key)) {
                max = map.get(key);
                answer = key;
            }
        }
        System.out.print(answer);
        br.close();
    }
}
