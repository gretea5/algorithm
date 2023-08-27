import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input1 = br.readLine();
        String input2 = br.readLine();
        int n1 = Integer.parseInt(input1);
        int n2 = Integer.parseInt(input2);
        int n3 =  n1 * (input2.charAt(2) - '0');
        int n4 =  n1 * (input2.charAt(1) - '0');
        int n5 =  n1 * (input2.charAt(0) - '0');
        int n6 = n1 * n2;
        sb.append(n3).append("\n");
        sb.append(n4).append("\n");
        sb.append(n5).append("\n");
        sb.append(n6);
        System.out.print(sb);
        br.close();
    }
}
