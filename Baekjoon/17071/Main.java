import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
/*
    수빈이를 이동시킨다.
    한 점에 time의 시간에 방문했었다면 time + 2, time + 4에도 또 다시 방문이 될 수 있다.
    수빈이가 +1 -1로 이동하면서 동생이 와서 만났을 경우도 생각해봐야함
*
 */
public class Main {
    private static final int MAX_LENGTH = 500_001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        //동생과 수빈이가 같은 위치에 있을 경우, 0
        if (n == k) {
            System.out.print(0);
            return;
        }

        ArrayDeque<Integer> queue = new ArrayDeque<>();

        //왜 2가 될까 => 어떤 위치에 있다면 2초씩 지나면 다시 돌아올 수 있기 때문
        boolean[][] visited = new boolean[MAX_LENGTH][2];

        queue.addLast(n);
        visited[n][0] = true;

        int time = 1;

        int answer = -1;

        while (!queue.isEmpty()) {
            //동생을 이동시킴
            k += time;

            //동생을 찾을 수 있는 위치가 50만을 넘어갔을 경우,
            if (k >= MAX_LENGTH) {
                break;
            }

            //2를 나눈 나머지를 구함, 어차피 -1 +1을 하면 왔다갔다 할 것이므로,
            int rest = time % 2;

            //time에 따른 정점을 모두 꺼낸다.
            int count = queue.size();

            while (count > 0) {
                //수빈이의 현재 위치 꺼내기
                int cur = queue.removeFirst();

                //움직인 위치 배열
                int[] mx = {cur + 1, cur - 1, cur * 2};

                for (int i = 0; i < 3; i++) {
                    //범위를 벗어날 경우,
                    if (mx[i] < 0 || mx[i] >= MAX_LENGTH) continue;

                    //방문처리가 되었다면
                    if (visited[mx[i]][rest]) continue;

                    queue.addLast(mx[i]);
                    visited[mx[i]][rest] = true;
                }

                count -= 1;
            }

            //수빈이를 time에 이동시켰는데 => 방문처리가 되었다? 만난 것
            if (visited[k][rest]) {
                answer = time;
                break;
            }

            //흐른 시간
            time += 1;
        }

        System.out.print(answer);

        br.close();
    }
}
