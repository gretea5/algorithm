import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] b = new int[m];

        st = new StringTokenizer(br.readLine(), " ");

        for(int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        ArrayList<Integer> aSumList = new ArrayList<>();
        ArrayList<Integer> bSumList = new ArrayList<>();

        for(int i = 0; i < n; i++) {
            int sum = 0;

            for(int j = i; j < n; j++) {
                sum += a[j];
                aSumList.add(sum);
            }
        }

        for(int i = 0; i < m; i++) {
            int sum = 0;

            for(int j = i; j < m; j++) {
                sum += b[j];
                bSumList.add(sum);
            }
        }

        Collections.sort(aSumList);
        Collections.sort(bSumList);

        int left = 0;
        int right = bSumList.size() - 1;
        long answer = 0;

        while(left < aSumList.size() && right >= 0) {
            int sum = aSumList.get(left) + bSumList.get(right);

            if(sum == t) {
                int aSum = aSumList.get(left);
                int bSum = bSumList.get(right);

                long aCnt = 0;
                long bCnt = 0;

                while(left < aSumList.size() && aSum == aSumList.get(left)) {
                    aCnt += 1;
                    left += 1;
                }

                while(right >= 0 && bSum == bSumList.get(right)) {
                    bCnt += 1;
                    right -= 1;
                }

                answer += (aCnt * bCnt);
            }
            else if(sum > t) {
                right -= 1;
            }
            else {
                left += 1;
            }
        }

        System.out.print(answer);

        br.close();
    }
}
