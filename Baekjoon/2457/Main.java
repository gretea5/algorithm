import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    static class Flower {
        int start;
        int end;

        Flower(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static final int START_PERIOD = 301;
    private static final int END_PERIOD = 1130;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Flower[] arr = new Flower[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int startMonth = Integer.parseInt(st.nextToken());
            int startDay = Integer.parseInt(st.nextToken());

            int endMonth = Integer.parseInt(st.nextToken());
            int endDay = Integer.parseInt(st.nextToken());

            arr[i] = new Flower(startMonth * 100 + startDay, endMonth * 100 + endDay);
        }

        //시작일, 끝나는 일 오름차순 정렬
        Arrays.sort(arr, (f1, f2) -> {
            if (f1.start == f2.start) {
                return f1.end - f2.end;
            }

            return f1.start - f2.start;
        });

        int startDay = 301;
        int curIdx = 0;

        int answer = 0;
        int max = 0;

        while (true) {
            boolean isFound = false;

            for (int i = curIdx; i < n; i++) {
                //end가 최대인 값을 찾아야하는데, 시작일 같거나 작으면서 end가 최대인 값을 찾음
                if (arr[i].start <= startDay && max < arr[i].end) {
                    isFound = true;
                    max = arr[i].end;
                    curIdx = i + 1;
                }
            }

            //끝나는 날의 최댓값이 시작일이 됨
            startDay = max;

            answer += 1;

            if (!isFound || startDay > 1130) {
                break;
            }
        }

        //최대를 구했는데 1130일 이하면 0 아니면 정답 출력
        System.out.print(max <= 1130 ?  0 : answer);

        br.close();
    }
}
