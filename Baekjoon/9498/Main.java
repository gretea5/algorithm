import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int score = Integer.parseInt(br.readLine());
        char grade = ' ';
        if (score > 89) {
            grade = 'A';
        }
        else if (score > 79) {
            grade = 'B';
        }
        else if (score > 69) {
            grade = 'C';
        }
        else if (score > 59) {
            grade = 'D';
        }
        else {
            grade = 'F';
        }
        System.out.print(grade);
        br.close();
    }
}
