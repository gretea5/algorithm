import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static class Info {
        int joinNumber;
        String name;

        Info (int joinNumber, String name) {
            this.joinNumber = joinNumber;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        Info[] arr = new Info[3];

        int sum = 0;

        for (int i = 0; i < 3; i++) {
            int v = Integer.parseInt(st.nextToken());

            sum += v;

            if (i == 0) {
                arr[i] = new Info(v, "Soongsil");
            }
            else if (i == 1) {
                arr[i] = new Info(v, "Korea");
            }
            else {
                arr[i] = new Info(v, "Hanyang");
            }
        }

        Arrays.sort(arr, (i1, i2) -> i1.joinNumber - i2.joinNumber);

        if (sum >= 100) {
            System.out.print("OK");
        }
        else {
            System.out.print(arr[0].name);
        }

        br.close();
    }
}
