import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        
        Arrays.sort(copyArr);

        HashMap<Integer, Integer> map = new HashMap<>();

        int rank = 0;
        
        for(int i = 0; i < copyArr.length; i++) {
            if(!map.containsKey(copyArr[i])) {
                map.put(copyArr[i], rank);
                rank += 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for (int v : arr) {
            sb.append(map.get(v)).append(" ");
        }

        System.out.print(sb);

        br.close();
    }
}
