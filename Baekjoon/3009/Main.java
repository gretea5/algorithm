import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        HashMap<Integer, Integer> xMap = new HashMap<>();
        HashMap<Integer, Integer> yMap = new HashMap<>();
        
        for(int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            xMap.put(x, xMap.getOrDefault(x, 0) + 1);
            yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        }
        
        int answerX = -1;
        
        for(int key : xMap.keySet()) {
            int value = xMap.get(key);
            
            if (value == 1) {
                answerX = key;
            }
        }
        
        int answerY = -1;
        
        for(int key : yMap.keySet()) {
            int value = yMap.get(key);
            
            if (value == 1) {
                answerY = key;
            }
        }
        
        System.out.print(answerX + " " + answerY);
        
        br.close();
    }
}
