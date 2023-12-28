import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashSet;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        HashSet<String> enterMap = new HashSet<>();
        HashSet<String> outMap = new HashSet<>();
        String S = st.nextToken();
        String E = st.nextToken();
        String Q = st.nextToken();
        while(true) {
            String input = br.readLine();
            if (input == null) break;
            st = new StringTokenizer(input, " ");
            String time = st.nextToken();
            String name = st.nextToken();
            if (S.compareTo(time) >= 0) {
                enterMap.add(name);
            }
            else if (E.compareTo(time) <= 0 && Q.compareTo(time) >= 0) {
                outMap.add(name);
            }
        }
        int count = 0;
        for(String name : enterMap) {
            if(outMap.contains(name)) {
                count++;
            }
        }
        System.out.print(count);
        br.close();
    }
}
