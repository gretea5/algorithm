import java.io.*;

public class Main {
    private static final String FIVE_STR = "@@@@@";
    private static final String ONE_STR = "@";

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        sb = new StringBuilder();

        printStrByCount(FIVE_STR, n);

        printStrByCount(ONE_STR, n);

        printStrByCount(FIVE_STR, n);

        printStrByCount(ONE_STR, n);

        printStrByCount(ONE_STR, n);

        System.out.print(sb);

        br.close();
    }

    private static void printStrByCount(String str, int cnt) {
        for (int i = 0; i < cnt; i++) {
            for (int j = 0; j < cnt; j++) {
                sb.append(str);
            }
            sb.append("\n");
        }
    }
}
