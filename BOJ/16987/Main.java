import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
/*
    1. 왼쪽을 들어서 오른쪽만 치는 걸로 문제 요구사항을 파악했던 것이 문제
    2. 치는 로직을 어떻게 구현해야할지 막막했는데, 재귀를 이용해야하는것을 파악하지 못함
 */
public class Main {
    private static int[][] eggs;
    private static int N, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        eggs = new int[N][2];
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            eggs[i][0] = s;
            eggs[i][1] = w;
        }
        answer = 0;
        backTrack(0, 0);
        System.out.print(answer);
        br.close();
    }
    private static void backTrack(int now, int brokenNumber) {
        answer = Math.max(answer, brokenNumber);
        if(now == N) {
            return;
        }
        if(eggs[now][0] <= 0) {
            backTrack(now + 1, brokenNumber);
        }
        else {
            for(int i = 0; i < N; i++) {
                if(eggs[i][0] <= 0) continue;
                if(i == now) continue;
                eggs[now][0] -= eggs[i][1];
                eggs[i][0] -= eggs[now][1];
                int newBrokenNumber = brokenNumber;
                if(eggs[now][0] <= 0) newBrokenNumber++;
                if(eggs[i][0] <= 0) newBrokenNumber++;
                backTrack(now + 1, newBrokenNumber);
                eggs[now][0] += eggs[i][1];
                eggs[i][0] += eggs[now][1];
            }
        }
    }
}
