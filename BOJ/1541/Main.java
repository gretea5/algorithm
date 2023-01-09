import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String plusArr[] = input.split("-");
        String minusArr[] = plusArr[0].split("[+]");
        int answer = 0;
        for(int i = 0; i < minusArr.length; i++) {
            answer += Integer.parseInt(minusArr[i]);
        }
        for(int i = 1; i < plusArr.length; i++) {
            minusArr = plusArr[i].split("[+]");
            for(int j = 0; j < minusArr.length; j++) {
                answer -= Integer.parseInt(minusArr[j]);
            }
        }
        System.out.print(answer);
        br.close();
    }
}
