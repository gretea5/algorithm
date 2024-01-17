import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.ArrayList;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //N, C 입력
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");

        //횟수, 먼저 나온 인덱스 HashMap 선언
        HashMap<Integer, Integer> countMap = new HashMap<>();
        HashMap<Integer, Integer> idxMap = new HashMap<>();

        //횟수와 먼저 나온 인덱스를 기록
        for(int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
            if(!idxMap.containsKey(num)) idxMap.put(num, i);
        }

        //key들을 ArrrayList에 담는다.
        ArrayList<Integer> keyList = new ArrayList<>(countMap.keySet());

        //정렬
        keyList.sort((n1, n2) -> {
            if(countMap.get(n1) == countMap.get(n2)) {
                //먼저 등장한 인덱스가 앞에 있어야한다.(오름차순)
                return idxMap.get(n1) - idxMap.get(n2);
            }
            //많이 등장하는 경우 앞에 있어야한다.(내림차순)
            return countMap.get(n2) - countMap.get(n1);
        });

        //출력
        StringBuilder sb = new StringBuilder();

        for(int key : keyList) {
            int count = countMap.get(key);
            for(int i = 0; i < count; i++) {
                sb.append(key).append(" ");
            }
        }

        System.out.print(sb);
        br.close();
    }
}
