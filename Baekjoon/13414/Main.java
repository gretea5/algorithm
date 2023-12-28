import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashMap<String, Integer> strMap = new HashMap<>();
        HashMap<Integer, String> numMap = new HashMap<>();
        int K = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= L; i++) {
            String number = br.readLine();
            if(strMap.containsKey(number)) {
                int order = strMap.get(number);
                strMap.remove(number);
                numMap.remove(order);
            }
            strMap.put(number, i);
            numMap.put(i, number);
        }
        ArrayList<Integer> list = new ArrayList<>(numMap.keySet());
        Collections.sort(list);
        StringBuilder sb = new StringBuilder();
        if (K > list.size()) {
            for(int key : list) {
                sb.append(numMap.get(key)).append("\n");
            }
        }
        else {
            for(int i = 0; i < K; i++) {
                int key = list.get(i);
                sb.append(numMap.get(key)).append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
