import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static String[] days = {"SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"};
    static int[] perMonth = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int sum = 0;
        for(int i = 1; i <= x-1; i++) {
            sum += perMonth[i];
        }
        sum += y;
        System.out.print(days[sum % 7]);
        br.close();
    }
}
