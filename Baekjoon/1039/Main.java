import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.HashSet;

/* k번 까지 수를 변경하면서 모든 수를 체크 */
public class Main {
    private static class Num {
        int value;
        int dist;

        Num(int value, int dist) {
            this.value = value;
            this.dist = dist;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        String s = st.nextToken();

        int length = s.length();

        int n = Integer.parseInt(s);
        int k = Integer.parseInt(st.nextToken());

        int answer = Integer.MIN_VALUE;

        ArrayDeque<Num> queue = new ArrayDeque<>();

        boolean[][] visited = new boolean[100_0001][k + 1];

        //큐에 데이터 넣기
        queue.addLast(new Num(n, 0));
        
        //0번 연산해서 n이 된적이 없으므로 방문처리
        visited[n][0] = true;

        while (!queue.isEmpty()) {
            Num cur = queue.removeFirst();

            int value = cur.value;
            int dist = cur.dist;

            //연산을 k번 수행했을 경우, 최댓값 구하고 continue
            if (dist == k) {
                answer = Math.max(answer, value);
                continue;
            }

            for (int i = 0; i < length; i++) {
                for (int j = i + 1; j < length; j++) {
                    int swapValue = swap(value, i, j);

                    //0으로 시작하지 않으면서, dist + 1 번째로 바꿨을때, swapValue가 된적이 없다면
                    //바꿀 수 있음
                    if (swapValue != -1 && !visited[swapValue][dist + 1]) {
                        queue.addLast(new Num(swapValue, dist + 1));
                        visited[swapValue][dist + 1] = true;
                    }
                }
            }
        }

        if (answer == Integer.MIN_VALUE) {
            System.out.print(-1);
            return;
        }

        System.out.print(answer);

        br.close();
    }

    /*value의 i, j를 바꾸고 정수로 리턴해주는 함수*/
    private static int swap(int value, int i, int j) {
        //문자 하나하나씩으로 자름
        char[] arr = String.valueOf(value).toCharArray();

        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        //0으로 시작하면 -1
        if (arr[0] == '0') {
            return -1;
        }

        StringBuilder sb = new StringBuilder();

        for (char ch : arr) {
            sb.append(ch);
        }

        return Integer.parseInt(sb.toString());
    }


}
