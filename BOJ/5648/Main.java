import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(sc.next());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = reverseNum(sc.next());
        }
        Arrays.sort(arr);
        for (long x : arr) {
            sb.append(x + " ");
        }
        System.out.print(sb);
    }

    private static long reverseNum(String str) {
        StringBuilder sb = new StringBuilder(str);
        return Long.parseLong(sb.reverse().toString());
    }
}
