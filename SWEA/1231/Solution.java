import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        char ch;
        int left;
        int right;

        Node(char ch) {
            this(ch, NOTHING_NUM, NOTHING_NUM);
        }

        Node(char ch, int left) {
            this(ch, left, NOTHING_NUM);
        }

        Node(char ch, int left, int right) {
            this.ch = ch;
            this.left = left;
            this.right = right;
        }
    }

    private static final int START_NUM = 0;
    private static final int NOTHING_NUM = -1;
    private static Node[] arr;

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        sb = new StringBuilder();

        for (int testCase = 1; testCase <= 10; testCase++) {
            sb.append("#").append(testCase).append(" ");
            int n = Integer.parseInt(br.readLine());

            arr = new Node[n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                if (st.countTokens() == 2) {
                    int num = Integer.parseInt(st.nextToken()) - 1;
                    char ch = st.nextToken().charAt(0);

                    arr[num] = new Node(ch);
                }
                else if (st.countTokens() == 3) {
                    int num = Integer.parseInt(st.nextToken()) - 1;
                    char ch = st.nextToken().charAt(0);
                    int left = Integer.parseInt(st.nextToken()) - 1;

                    arr[num] = new Node(ch, left);
                }
                else {
                    int num = Integer.parseInt(st.nextToken()) - 1;
                    char ch = st.nextToken().charAt(0);
                    int left = Integer.parseInt(st.nextToken()) - 1;
                    int right = Integer.parseInt(st.nextToken()) - 1;

                    arr[num] = new Node(ch, left, right);
                }
            }

            inOrder(START_NUM);

            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void inOrder(int num) {
        if (num == NOTHING_NUM) {
            return;
        }

        inOrder(arr[num].left);
        sb.append(arr[num].ch);
        inOrder(arr[num].right);
    }
}
