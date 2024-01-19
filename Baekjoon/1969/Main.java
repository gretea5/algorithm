import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] arr = new String[N];

        for(int i = 0; i < N; i++) {
            arr[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();
        int sum = 0;

        for(int i = 0; i < M; i++) {
            int[] cnt = new int[4];

            //최대 빈도수 문자의 개수를 구한다.
            for(int j = 0; j < N; j++) {
                char ch = arr[j].charAt(i);
                if(ch == 'A') cnt[0] += 1;
                else if(ch == 'C') cnt[1] += 1;
                else if(ch == 'G') cnt[2] += 1;
                else cnt[3] += 1;
            }

            //최대 빈도수와 그에 대한 인덱스를 구한다.
            int max = Integer.MIN_VALUE;
            int maxIdx = -1;

            //최대 빈도수 문자에 대한 인덱스를 구한다.(사전 순 보장)
            for(int j = 0; j < 4; j++) {
                if(cnt[j] > max) {
                    max = cnt[j];
                    maxIdx = j;
                }
            }

            //문자 붙이기
            if(maxIdx == 0) sb.append('A');
            else if(maxIdx == 1) sb.append('C');
            else if(maxIdx == 2) sb.append('G');
            else sb.append('T');

            //최대 빈도로 나오는 문자를 제외한 나머지 문자의 개수를 구한다.(최소 distance)
            for(int j = 0; j < 4; j++) {
                if(j != maxIdx) sum += cnt[j];
            }
        }
        //출력
        System.out.println(sb.toString());
        System.out.print(sum);

        br.close();
    }
}
