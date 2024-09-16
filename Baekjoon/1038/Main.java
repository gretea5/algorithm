import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static ArrayList<Long> list;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        //감소하는 수를 담은 리스트
        list = new ArrayList<>();
        
        backTrack("", 9, 0);
        
        if (list.size() < n + 1) {
            System.out.print(-1);
            return;
        }
        
        //오름차순 정렬
        Collections.sort(list);
        
        //출력
        System.out.print(list.get(n));
        
        br.close();
    }
    
    private static void backTrack(String s, int idx, int depth) {
        if (depth > 10) {
            return;
        }
        
        if (!s.isEmpty()) {
            list.add(Long.parseLong(s));
        }
        
        for (int i = idx; i >= 0; i--) {
            backTrack(s + i, i - 1, depth + 1);
        }
    }
}
