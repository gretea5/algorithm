import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static int n;
    
    private static boolean[] isChecked;
    
    private static ArrayList<String> strList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        isChecked = new boolean[n + 1];
        
        strList = new ArrayList<>();
        
        backTrack("", 0);
        
        Collections.sort(strList);
        
        StringBuilder sb = new StringBuilder();
        
        for(String s : strList) {
            sb.append(s.trim()).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
    
    private static void backTrack(String s, int depth) {
        if (depth == n)  {
            strList.add(s);
            return;
        }
        
        for(int i = 1; i <= n; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                
                backTrack(s + " " + i, depth + 1);
                
                isChecked[i] = false;
            }
        }
    }
}
