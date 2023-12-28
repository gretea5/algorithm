import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String answer = br.readLine();
        answer = answer.replace("XXXX", "AAAA");
        answer = answer.replace("XX", "BB");
        if(answer.contains("X")) System.out.print(-1);
        else System.out.print(answer);
        br.close();
    }
}
