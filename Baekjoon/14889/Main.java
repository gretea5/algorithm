import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int answer;

    private static int[][] score;
    private static boolean[] selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력
        N = Integer.parseInt(br.readLine());

        //능력치, 선택된 배열 초기화
        score = new int[N + 1][N + 1];
        selected = new boolean[N + 1];

        //능력치 배열 입력
        for(int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            for(int j = 1; j <= N; j++) {
                score[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //차이의 최솟값을 담을 배열
        answer = Integer.MAX_VALUE;

        backTrack(0, 1);

        System.out.print(answer);

        br.close();
    }

    private static void backTrack(int depth, int idx) {
        if(depth == N / 2) {
            //선택된 능력치들의 합과
            //선택되지 않은 능력치들의 합
            int selectedSum = 0;
            int nonSelectSum = 0;

            for(int i = 1; i <= N; i++) {
                for(int j = i + 1; j <= N; j++) {
                    if(selected[i] && selected[j])  {
                        selectedSum += (score[i][j] + score[j][i]);
                    }
                    else if(!selected[i] && !selected[j]) {
                        nonSelectSum += (score[i][j] + score[j][i]);
                    }
                }
            }

            answer = Math.min(answer, Math.abs(selectedSum - nonSelectSum));

            return;
        }

        for(int i = idx; i <= N; i++) {
            if(!selected[i]) {
                selected[i] = true;
                backTrack(depth + 1, i + 1);
                selected[i] = false;
            }
        }
    }
}
