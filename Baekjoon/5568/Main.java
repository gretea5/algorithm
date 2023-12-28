import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;
public class Main {
    private static int n, k;
    private static HashSet<Integer> set;
    private static int[] arr;
    private static boolean[] used;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        arr = new int[n];
        used = new boolean[n];
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        set = new HashSet<>();
        makeNumber("", 0);
        System.out.print(set.size());
        br.close();
    }
    private static void makeNumber(String s, int count) {
        if(!s.isEmpty() && count == k) {
            set.add(Integer.parseInt(s.trim()));
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(!used[i]) {
                used[i] = true;
                makeNumber(s + arr[i], count + 1);
                used[i] = false;
            }
        }
    }
}
