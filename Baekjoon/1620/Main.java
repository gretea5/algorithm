import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        HashMap<String, Integer> strBook = new HashMap<>();
        HashMap<Integer, String> IntegerBook = new HashMap<>();
        for(int i = 1; i <= N; i++) {
            String name = br.readLine();
            strBook.put(name, i);
            IntegerBook.put(i, name);
        }
        for(int i = 1; i <= M; i++) {
            String inputStr = br.readLine();
            if(strIsDigit(inputStr)) {
                int num = Integer.parseInt(inputStr);
                sb.append(IntegerBook.get(num)).append("\n");
            }
            else {
                sb.append(strBook.get(inputStr)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
    public static Boolean strIsDigit(String str) {
        boolean isDigit = true;
        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if(!Character.isDigit(ch)) {
                isDigit = false;
                break;
            }
        }
        return isDigit;
    }
}
