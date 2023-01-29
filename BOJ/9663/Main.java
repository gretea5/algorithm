import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static boolean[] isUsed1 = new boolean[40];
    static boolean[] isUsed2 = new boolean[40];
    static boolean[] isUsed3 = new boolean[40];
    static int count = 0;
    static int N;
    public static void func(int cur) {
        if (cur == N) {
            count += 1;
            return;
        }
        for(int i = 0; i < N; i++) {
            if(isUsed1[i] || isUsed2[i + cur] || isUsed3[cur - i + N - 1]) {
                continue;
            }
            isUsed1[i] = true;
            isUsed2[i + cur] = true;
            isUsed3[cur - i + N - 1] = true;
            func(cur + 1);
            isUsed1[i] = false;
            isUsed2[i + cur] = false;
            isUsed3[cur - i + N - 1] = false;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        func(0);
        System.out.print(count);
        br.close();
    }
}
