import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[3];
        for(int i = 0; i < 3; i++) {
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        StringBuilder sb = new StringBuilder();
        for(int value : arr) {
            sb.append(value).append(" ");
        }
        System.out.print(sb);
        scanner.close();
    }
}
