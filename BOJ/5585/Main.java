import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;


public class Main {
    public static int totalMoney = 1000;
    public static int moneyArr[] = {500, 100, 50, 10, 5, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int payMoney = Integer.parseInt(br.readLine());
        int restMoney = totalMoney - payMoney;
        int totalcount = 0;
        for(int i = 0; i < moneyArr.length; i++) {
            int count = (restMoney / moneyArr[i]);
            totalcount += (restMoney / moneyArr[i]);
            restMoney -= (moneyArr[i] * count);
        }
        System.out.print(totalcount);
        br.close();
    }
}

