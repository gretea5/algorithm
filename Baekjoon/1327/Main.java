import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.ArrayDeque;
import java.util.HashSet;

public class Main {
    private static class SortObect {
        String s;
        int n;

        SortObect(String s, int n) {
            this.s = s;
            this.n = n;
        }
    }

    private static int N, K;

    private static String sortedStr, originalStr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //N, K 입력
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        //정렬할 배열
        char[] sortedArr = br.readLine().replace(" ", "").toCharArray();

        //원본 문자 배열 복사
        char[] original = Arrays.copyOf(sortedArr, N);

        //오름차순 정렬
        Arrays.sort(sortedArr);

        //문자열 만들기
        sortedStr = new String(sortedArr);
        originalStr = new String(original);

        System.out.print(bfs());

        br.close();
    }

    private static int bfs() {
        ArrayDeque<SortObect> queue = new ArrayDeque<>();
        HashSet<String> set = new HashSet<>();
        
        queue.addLast(new SortObect(originalStr, 0));

        while(!queue.isEmpty()) {
            SortObect obj = queue.removeFirst();

            //같을 경우
            if(obj.s.equals(sortedStr)) {
                return obj.n;
            }

            //집합에 들어 있지 않는 경우
            if(!set.contains(obj.s)) {
                set.add(obj.s);
                for(int i = 0; i <= N - K; i++) {
                    queue.addLast(new SortObect(reverseStr(obj.s, i, i + K) ,obj.n + 1));
                }
            }
        }

        return -1;
    }

    private static String reverseStr(String str, int start, int end) {
        StringBuilder sb = new StringBuilder();

        sb.append(str.substring(0, start));

        String reverse = str.substring(start, end);

        for(int i = K - 1; i >= 0; i--) {
            sb.append(reverse.charAt(i));
        }

        sb.append(str.substring(end));

        return sb.toString();
    }

}
