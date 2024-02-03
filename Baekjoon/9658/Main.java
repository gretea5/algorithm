import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        //상영이가 이기는 경우 true
        boolean[] isWin = new boolean[1001];

        isWin[1] = false;
        isWin[2] = true;
        isWin[3] = false;
        isWin[4] = true;

        for(int i = 5; i < 1001; i++) {
            //모두 상영이가 이기는 경우 그 다음턴에는 상영이가 진다.
            if(isWin[i - 4] && isWin[i - 3] && isWin[i - 1]) isWin[i] = false;
            //상영이가 하나라도 이기지 못하는 경우 상영이가 이길 수 있다.
            else isWin[i] = true;
        }

        bw.write(isWin[N] ? "SK" : "CY");

        bw.flush();

        bw.close();
        br.close();
    }

}
