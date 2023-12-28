import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    private static String str;
    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //문자열 입력
        str = br.readLine();
        br.close();
    }
    private static void solve() {
        int answer = 0;
        //최소 시간 계산
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if('A' <= ch && ch <= 'C') {
                answer += 3;
            }
            else if ('D' <= ch && ch <= 'F') {
                answer += 4;
            }
            else if ('G' <= ch && ch <= 'I') {
                answer += 5;
            }
            else if ('J' <= ch && ch <= 'L') {
                answer += 6;
            }
            else if ('M' <= ch && ch <= 'O') {
                answer += 7;
            }
            else if ('P' <= ch && ch <= 'S') {
                answer += 8;
            }
            else if ('T' <= ch && ch <= 'V') {
                answer += 9;
            }
            else if ('W' <= ch && ch <= 'Z') {
                answer += 10;
            }
        }
        //출력
        System.out.print(answer);
    }
    public static void main(String[] args) throws IOException {
        input();
        solve();
    }
}
