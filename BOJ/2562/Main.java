import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = Integer.MIN_VALUE;
        int maxCount = -1;
        for(int i = 1; i <= 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if(max < num) {
                max = num;
                maxCount = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(max).append("\n").append(maxCount).append("\n");
        System.out.print(sb.toString());
        br.close();
    }
}
