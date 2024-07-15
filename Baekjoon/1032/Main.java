import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        String[] arr = new String[n];
        
        for(int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }
        
        int length = arr[0].length();
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            //문자를 하나하나 꺼냄
            char ch = arr[0].charAt(i);
            
            boolean flag = true;
            
            for (int j = 0; j < n; j++) {
                if (ch != arr[j].charAt(i)) {
                    flag = false;
                    break;
                }
            }
            
            if (!flag) {
                sb.append('?');
            }
            else {
                sb.append(ch);
            }
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
