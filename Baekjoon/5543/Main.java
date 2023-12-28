import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class Main {
    private static final int HAMBURGERNUMBER = 3;
    private static final int DRINKNUMBER = 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] hamburgers = new int[HAMBURGERNUMBER];
        int[] drinks = new int[DRINKNUMBER];
        for(int i = 0; i < HAMBURGERNUMBER; i++) {
            hamburgers[i] = Integer.parseInt(br.readLine());
        }
        for(int i = 0; i < DRINKNUMBER; i++) {
            drinks[i] = Integer.parseInt(br.readLine());
        }
        int min = Integer.MAX_VALUE;
        for(int hamburger: hamburgers) {
            for(int drink: drinks) {
                min = Math.min(min, hamburger + drink - 50);
            }
        }
        System.out.print(min);
        br.close();
    }
}
