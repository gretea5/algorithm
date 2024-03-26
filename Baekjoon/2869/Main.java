import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int cost = (V - A) / (A - B);

        //즉 A - B 하루 이동거리를 이동했는데 나머지가 있다면! 하루 더 이동해야함!
        if ((V - A) % (A - B) != 0) {
            cost += 1;
        }

        //V - A 만큼 이동했으므로 나머지 A만큼 하루만 더 이동하면 돼!!
        System.out.print(cost + 1);

        br.close();
    }
}
