import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        //하루에 일을 한 피로도가 한계점의 피로도보다 높을 경우,
        if (A > M) {
            System.out.print(0);
            return;
        }
        int fatigue = 0;
        int workAmount = 0;
        int hour = 0;
        //그게 아닐 경우 계산
        while(true) {
            if (hour == 24) {
                break;
            }
            if (fatigue + A > M) {
                fatigue -= C;
                if (fatigue < 0) {
                    fatigue = 0;
                }
            } else {
                fatigue += A;
                workAmount += B;
            }
            hour += 1;
        }
        System.out.print(workAmount);
        br.close();
    }
}

