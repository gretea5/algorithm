import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long distanceArr[] = new long[N - 1];
        long oilUnitArr[] = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        //두 도시간의 거리를 입력
        for(int i = 0; i < N - 1; i++) {
            distanceArr[i] = Long.parseLong(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(), " ");
        //도시의 기름 단위를 입력
        for(int i = 0; i < N; i++) {
            oilUnitArr[i] = Long.parseLong(st.nextToken());
        }
        long result = 0;
        long min = oilUnitArr[0];
        for(int i = 1; i < N; i++) {
            result += (min * distanceArr[i - 1]);
            if (min > oilUnitArr[i]) {
                min = oilUnitArr[i];
            }
        }
        System.out.print(result);
        br.close();
    }
}

