import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap; 
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        String s;
        
        while((s = br.readLine()) != null) {
            char[] arr = s.toCharArray();
            
            for(char ch : arr) {
                if ('a' <= ch && ch <= 'z') {
                    map.put(ch, map.getOrDefault(ch, 0) + 1);
                }
            }
        }
        
        ArrayList<Character> alphaList = new ArrayList<>();
        
        int max = Integer.MIN_VALUE;
        
        for(char key : map.keySet()) {
            int value = map.get(key);
            
            if (max < value) {
                alphaList.clear();
                
                alphaList.add(key);
                max = value;
            }
            else if (max == value) {
                alphaList.add(key);
            }
        }
        
        Collections.sort(alphaList);
        
        StringBuilder sb = new StringBuilder();
        
        for(char ch : alphaList) {
            sb.append(ch);
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
