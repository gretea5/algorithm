import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Arrays;

import java.lang.Math;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while(true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int[] length = new int[3];
            for(int i = 0; i < 3; i++) {
                length[i] = Integer.parseInt(st.nextToken());
            }
            if(length[0] == 0 && length[1] == 0 && length[2] == 0) {
                break;
            }
            Arrays.sort(length);
            int calNumber = (int) (Math.pow(length[2], 2) - Math.pow(length[1], 2) - Math.pow(length[0], 2));
            sb.append((calNumber == 0 ? "right" : "wrong")).append("\n");
        }
        System.out.print(sb);
        br.close();
    }
}
