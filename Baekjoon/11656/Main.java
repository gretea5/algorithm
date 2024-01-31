import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        ArrayList<String> arr = new ArrayList<>();

        for(int i = 0; i < s.length(); i++) {
            arr.add(s.substring(i));
        }

        Collections.sort(arr);

        StringBuilder sb = new StringBuilder();

        for(String str : arr) {
            sb.append(str).append("\n");
        }

        System.out.print(sb);

        br.close();
    }
}
