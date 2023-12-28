import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            arr.add(i);
        }
        while(arr.size() != 1) {
            ArrayList<Integer> temp = new ArrayList<>();
            for(int i = 1; i < arr.size(); i += 2) {
                temp.add(arr.get(i));
            }
            arr = temp;
        }
        System.out.print(arr.get(0));
        br.close();
    }
}
