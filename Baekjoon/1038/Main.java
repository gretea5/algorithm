import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<Long> arr;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();

        for(int i = 0; i < 10; i++) {
            backTrack(i, 0);
        }

        Collections.sort(arr);

        if(arr.size() <= N) {
            System.out.print(-1);
            return;
        }

        System.out.print(arr.get(N));

        br.close();
    }

    private static void backTrack(long num, int depth) {
        if(depth > 10) {
            return;
        }

        arr.add(num);

        for(int i = 0; i < (num % 10); i++) {
            backTrack((num * 10) + i, depth + 1);
        }
    }
}
