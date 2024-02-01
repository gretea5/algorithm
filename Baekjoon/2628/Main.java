import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int xSize = Integer.parseInt(st.nextToken()) + 1;
        int ySize = Integer.parseInt(st.nextToken()) + 1;

        boolean[] cutX = new boolean[xSize];
        boolean[] cutY = new boolean[ySize];

        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int type = Integer.parseInt(st.nextToken());
            int cut = Integer.parseInt(st.nextToken());

            if(type == 0) cutY[cut] = true;
            else if(type == 1) cutX[cut] = true;
        }

        ArrayList<Integer> xLengthArr = new ArrayList<>();
        ArrayList<Integer> yLengthArr = new ArrayList<>();

        int start = 0;

        for(int i = 0; i < cutX.length; i++) {
            //잘렸다면
            if(cutX[i] || i == cutX.length - 1) {
                xLengthArr.add(i - start);
                start = i;
            }
        }

        start = 0;

        for(int i = 0; i < cutY.length; i++) {
            if(cutY[i] || i == cutY.length - 1) {
                yLengthArr.add(i - start);
                start = i;
            }
        }

        int x = Collections.max(xLengthArr);
        int y = Collections.max(yLengthArr);

        System.out.print(x * y);

        br.close();
    }
}
