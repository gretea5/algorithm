import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int n3 = Integer.parseInt(st.nextToken());

            if(n1 == 0 && n2 == 0 && n3 == 0) {
                break;
            }

            ArrayList<Integer> arr = new ArrayList<>();

            arr.add(n1);
            arr.add(n2);
            arr.add(n3);

            Collections.sort(arr);

            if(arr.get(0) + arr.get(1) <= arr.get(2)) {
                sb.append("Invalid").append("\n");
            }
            else {
                HashSet<Integer> set = new HashSet<>(arr);

                if(set.size() == 3) {
                    sb.append("Scalene").append("\n");
                }
                else if(set.size() == 2) {
                    sb.append("Isosceles").append("\n");
                }
                else {
                    sb.append("Equilateral").append("\n");
                }
            }
        }

        System.out.print(sb);

        br.close();
    }
}
