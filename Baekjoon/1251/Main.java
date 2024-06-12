import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        
        ArrayList<String> strArr = new ArrayList<>();
        
        for(int i = 1; i < s.length(); i++) {
            for(int j = i + 1; j < s.length(); j++) {
                String s1 = s.substring(0, i);
                String s2 = s.substring(i, j);
                String s3 = s.substring(j);
                
                String r1 = new StringBuilder(s1).reverse().toString();
                String r2 = new StringBuilder(s2).reverse().toString();
                String r3 = new StringBuilder(s3).reverse().toString();
                
                StringBuilder builder = new StringBuilder();
                
                builder.append(r1);
                builder.append(r2);
                builder.append(r3);
                
                strArr.add(builder.toString());
            }
        }
        
        Collections.sort(strArr);
        
        System.out.print(strArr.get(0));
        
        br.close();
    }
}
