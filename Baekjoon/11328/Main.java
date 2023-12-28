import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int k = 0; k < N; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            char[] firstCharArray = st.nextToken().toCharArray();
            char[] secondCharArray = st.nextToken().toCharArray();
            Arrays.sort(firstCharArray);
            Arrays.sort(secondCharArray);
            String s1 = new String(firstCharArray);
            String s2 = new String(secondCharArray);
            if (s1.equals(s2)) {
                sb.append("Possible").append("\n");
            }
            else {
                sb.append("Impossible").append("\n");
            }
        }
        System.out.print(sb);
        br.close();
    }
}
