import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //문자 입력 배열 선언
        char[][] arr = new char[5][15];
        //문자가 있는지 여부를 기록할 배열
        boolean[][] flag = new boolean[5][15];
        //배열 입력
        for(int i = 0; i < 5; i++) {
            String input = br.readLine();
            for(int j = 0; j < input.length(); j++) {
                arr[i][j] = input.charAt(j);
                flag[i][j] = true;
            }
        }
        //세로로 출력
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 15; i++) {
            for(int j = 0; j < 5; j++) {
                if(flag[j][i]) {
                    sb.append(arr[j][i]);
                }
            }
        }
        System.out.print(sb);
        br.close();
    }
}
