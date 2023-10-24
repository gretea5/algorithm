import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Solution {
    //박수 문자열
    private static String CLAP = "-";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //N입력
        int N = Integer.parseInt(br.readLine());
        for(int i = 1; i <= N; i++) {
            //출력 형식 저장(변환 함수 호출)
            sb.append(changeClap(String.valueOf(i))).append(" ");
        }
        //출력
        System.out.print(sb);
        br.close();
    }
    private static String changeClap(String str) {
        //3 6 9 포함되어있으면 박수 아니면 원래 수를 리턴해주는 함수
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for(int i = 0; i < str.length(); i++) {
            int value = str.charAt(i) - '0';
            if(value % 3 == 0 && value != 0) {
                sb.append(CLAP);
                flag = true;
            }
        }
        //3, 6, 9 포함되어있을 경우
        if(flag) {
            return sb.toString();
        }
        return str;
    }
}
