import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
public class Main {
    private static int L, C;
    private static char[] arr;
    private static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        arr = new char[C];
        st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < C; i++) {
            arr[i] = st.nextToken().charAt(0);
        }
        Arrays.sort(arr);
        backTrack("", 0, ' ');
        System.out.print(sb);
        br.close();
    }
    private static void backTrack(String s, int length, char before) {
        if(length == L && check(s.trim())) {
            sb.append(s.trim()).append("\n");
            return;
        }
        for(int i = 0; i < arr.length; i++) {
            if(before < arr[i]) {
                backTrack(s + arr[i], length + 1, arr[i]);
            }
        }
    }
    private static boolean check(String s) {
        int numOfVowel = 0;
        int numOfOthers = 0;
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(isVowel(ch)) numOfVowel += 1;
            else numOfOthers += 1;
        }
        return numOfVowel >= 1 && numOfOthers >= 2;
    }
    private static boolean isVowel(char ch) {
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
    }
}
