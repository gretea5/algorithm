
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static ArrayList<Integer> coinList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        //coinList에 넣기
        for(int i = 0; i < N; i++) {
            coinList.add(Integer.parseInt(br.readLine()));
        }
        //내림 차순 정렬
        Collections.sort(coinList, Collections.reverseOrder());
        int restMoney = K;
        int count = 0;
        for(int unit : coinList) {
            count += (restMoney / unit);
            restMoney -= (unit) * (restMoney / unit);
        }
        System.out.print(count);
        br.close();
    }
}

