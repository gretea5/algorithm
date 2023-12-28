import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static String coroatiaCharArr[] = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        for(int i = 0; i < coroatiaCharArr.length; i++) {
            if(input.contains(coroatiaCharArr[i])) {
                input = input.replace(coroatiaCharArr[i], "0");
            }
        }
        int answer = input.length();
        System.out.print(answer);
        br.close();
    }
}
