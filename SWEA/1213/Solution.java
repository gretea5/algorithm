import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= 10; test++) {
            int t = Integer.parseInt(br.readLine());

            String find = br.readLine();

            String search = br.readLine();

            String s = search.replace(find, "");

            sb.append("#").append(t).append(" ");
            sb.append((search.length() - s.length()) / find.length()).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
