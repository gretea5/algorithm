import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        HashMap<Integer, Integer> map = new HashMap<>();

        double sum = 0;

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
            sum += arr[i];
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        //배열 오름차순 정렬
        Arrays.sort(arr);

        //최빈값을 담을 ArrayList
        ArrayList<Integer> list = new ArrayList<>();

        //최대 빈도 수
        int max = Integer.MIN_VALUE;

        for(int key : map.keySet()) {
            //현재 key가 빈도수가 더 많다면
            if(max < map.get(key)) {
                //기존 list 데이터 모두 제거
                list.clear();

                //데이터 넣기
                list.add(key);

                //최대 빈도 수 갱신
                max = map.get(key);
            }
            //최대 빈도수와 같다면 데이터를 넣어준다.
            else if (max == map.get(key)) {
                list.add(key);
            }
        }

        Collections.sort(list);


        System.out.println(Math.round(sum / N));
        System.out.println(arr[arr.length / 2]);

        if(list.size() == 1) {
            System.out.println(list.get(0));
        }
        else {
            System.out.println(list.get(1));
        }

        System.out.print(arr[arr.length - 1] - arr[0]);

        br.close();
    }
}
