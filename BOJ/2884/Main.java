import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int H = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int alarmHour, alarmMinute;
        if (M - 45 < 0) {
            alarmMinute = M + 15;
            alarmHour = H - 1;
        }
        else {
            alarmMinute = M - 45;
            alarmHour = H;
        }
        if(alarmHour < 0) {
            alarmHour = 23;
        }
        System.out.print(alarmHour + " " + alarmMinute);
        br.close();
    }
}
