import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashSet<Character> set = new HashSet<>();
        
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        String s = br.readLine();
        
        int answer = 0;
        
        for(char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                answer += 1;
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
