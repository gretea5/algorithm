import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    private static HashMap<String, Double> map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        initMap();

        double sum = 0.0;
        double score = 0.0;

        while(true) {
            String input = br.readLine();

            if(input == null) break;

            StringTokenizer st = new StringTokenizer(input, " ");
            String name = st.nextToken();

            double s = Double.parseDouble(st.nextToken());

            String grade = st.nextToken();

            if(grade.equals("P")) continue;

            sum += s;

            score += (s * map.get(grade));
        }

        System.out.print(score / sum);

        br.close();
    }

    private static void initMap() {
        map = new HashMap<>();

        map.put("A+", 4.5);
        map.put("A0", 4.0);
        map.put("B+", 3.5);
        map.put("B0", 3.0);
        map.put("C+", 2.5);
        map.put("C0", 2.0);
        map.put("D+", 1.5);
        map.put("D0", 1.0);
        map.put("F", 0.0);
    }
}
