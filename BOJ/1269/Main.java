import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Set;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //집합
        Set<Integer> A = new HashSet<>();
        Set<Integer> B = new HashSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //집합의 개수 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine(), " ");
        //집합에 원소 입력
        for(int i = 0; i < N; i++) {
            A.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < M; i++) {
            B.add(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        //A에서 B에 포함되어 있지 않은 개수(차집합)
        for(int key : A) {
            if(!B.contains(key)) {
                answer += 1;
            }
        }
        //B에서 A에 포함되어 있지 않은 개수(차집합)
        for(int key: B) {
            if(!A.contains(key)) {
                answer += 1;
            }
        }
        //출력
        System.out.print(answer);
        br.close();
    }
}
