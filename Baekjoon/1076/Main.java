import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<String, Integer> map = new HashMap<>();
        
        map.put("black", 0);
        map.put("brown", 1);
        map.put("red", 2);
        map.put("orange", 3);
        map.put("yellow", 4);
        map.put("green", 5);
        map.put("blue", 6);
        map.put("violet", 7);
        map.put("grey", 8);
        map.put("white", 9);
        
        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();
        
        String v1 = String.valueOf(map.get(s1));
        String v2 = String.valueOf(map.get(s2));
        
        long answer = Long.parseLong(v1 + v2);
        
        int value = (int) Math.pow(10, map.get(s3));
        
        answer *= value;
        
        System.out.print(answer);
        
        br.close();
    }
}
