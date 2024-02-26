import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int N, M;

    private static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        heights = new int[N];

        st = new StringTokenizer(br.readLine(), " ");

        int left = 0;
        int right = Integer.MIN_VALUE;

        for(int i = 0; i < heights.length; i++) {
            heights[i] = Integer.parseInt(st.nextToken());
            right = Math.max(right, heights[i]);
        }

        int answer = Integer.MIN_VALUE;

        while(left <= right) {
            int mid = (left + right) / 2;

            //M이상인 길이를 가져갈 수 있을 경우, left를 1을 늘림
            if(checkHeight(mid)) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            }
            //M개를 가져갈 수 없을 경우, 높이를 줄여야함
            else {
                right = mid - 1;
            }
        }

        System.out.print(answer);

        br.close();
    }

    private static boolean checkHeight(int h) {
        long sum = 0;

        for(int height : heights) {
            int divHeight =  height - h;
            //잘린 길이가 0보다 작을 경우, 더할 필요가 없음
            if(divHeight > 0) sum += divHeight;
        }

        //계산된 길이가 M보다 같거나 크면 충족
        return sum >= M;
    }
}
