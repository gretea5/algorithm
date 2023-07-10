import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;
        int year = Integer.parseInt(br.readLine());
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)) {
            answer = 1;
        }
        System.out.print(answer);
        br.close();
    }
}
