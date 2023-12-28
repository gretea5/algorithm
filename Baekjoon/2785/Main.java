import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> arr = new ArrayList<>();
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //입력
        for(int i = 0; i < N; i++) {
            arr.add(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        //오름차순 정렬
        Collections.sort(arr);
        while(arr.size() >= 2) {
            //체인을 하나 뺐다.
            arr.set(0, arr.get(0) - 1);

            //체인을 하나 연결
            arr.remove(arr.size() - 1);

            //뺄 체인이 없다면 제거
            if(arr.get(0) == 0) {
                arr.remove(0);
            }
            //체인을 제거한 횟수
            answer += 1;
        }
        //출력
        System.out.print(answer);
        br.close();
    }
}
