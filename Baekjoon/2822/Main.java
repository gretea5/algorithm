import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 1; i <= 8; i++) {
            int score = Integer.parseInt(br.readLine());
            map.put(score, i);
        }

        ArrayList<Integer> keyList = new ArrayList<>(map.keySet());
        ArrayList<Integer> idxList = new ArrayList<>();

        //내림 차순 정렬
        Collections.sort(keyList, Collections.reverseOrder());

        //가장 높은 점수 5개의 합
        int sum = 0;

        //가장 높은 점수 5개의 합을 구하고, 문제 번호를 저장
        for (int i = 0; i < 5; i++) {
            int key = keyList.get(i);

            //합 구하기
            sum += key;

            //인덱스 저장
            idxList.add(map.get(key));
        }

        //문제 번호 증가하는 순서
        Collections.sort(idxList);

        StringBuilder sb = new StringBuilder();

        //합 출력
        sb.append(sum).append("\n");

        //문제 번호 오름차순 출력
        for (int idx : idxList) {
            sb.append(idx).append(" ");
        }

        //출력
        System.out.print(sb);

        br.close();
    }
}
