import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int EMax = 16;
    private static int SMax = 29;
    private static int MMax = 20;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //공백을 기준으로 자름
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //목표 E, S, M 입력
        int targetE = Integer.parseInt(st.nextToken());
        int targetS = Integer.parseInt(st.nextToken());
        int targetM = Integer.parseInt(st.nextToken());

        //시작 E, S, M 입력 및 구해야할 년도 초기화
        int startE = 0, startS = 0, startM = 0;
        int year = 0;

        //구해야할 년도 구하기
        while(true) {
            startE += 1;
            startS += 1;
            startM += 1;
            year += 1;

            if(startE == EMax) startE = 1;
            if(startS == SMax) startS = 1;
            if(startM == MMax) startM = 1;

            if(startE == targetE && startS == targetS && startM == targetM) {
                break;
            }
        }

        //출력
        System.out.print(year);
        br.close();
    }
}
