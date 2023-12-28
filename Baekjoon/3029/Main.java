import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String nowTime = br.readLine();
        String throwTime = br.readLine();
        if(nowTime.equals(throwTime)) {
            sb.append("24:00:00");
            System.out.print(sb);
            return;
        }
        String nowArr[] = nowTime.split(":");
        String throwArr[] = throwTime.split(":");
        int nowHour =  Integer.parseInt(nowArr[0]);
        int nowMinute = Integer.parseInt(nowArr[1]);
        int nowSecond = Integer.parseInt(nowArr[2]);
        int throwHour = Integer.parseInt(throwArr[0]);
        int throwMinute = Integer.parseInt(throwArr[1]);
        int throwSecond = Integer.parseInt(throwArr[2]);
        int time[] = new int[3];
        time[0] = throwHour - nowHour;
        time[1] = throwMinute - nowMinute;
        time[2] = throwSecond - nowSecond;
        if (time[2] < 0) {
            time[2] += 60;
            time[1] -= 1;
        }
        if (time[1] < 0) {
            time[1] += 60;
            time[0] -= 1;
        }
        if (time[0] < 0) {
            time[0] += 24;
        }
        if(time[0] < 10) {
            sb.append("0").append(time[0]).append(":");
        } else {
            sb.append(time[0]).append(":");
        }
        if(time[1] < 10) {
            sb.append("0").append(time[1]).append(":");
        } else {
            sb.append(time[1]).append(":");
        }
        if(time[2] < 10) {
            sb.append("0").append(time[2]);
        } else {
            sb.append(time[2]);
        }
        System.out.print(sb);
        br.close();
    }
}
