import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.TreeMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            int k = Integer.parseInt(br.readLine());

            TreeMap<Integer, Integer> map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                char ch = st.nextToken().charAt(0);
                int n = Integer.parseInt(st.nextToken());

                if (ch == 'I') {
                    map.put(n, map.getOrDefault(n, 0) + 1);
                }
                else {
                    if (map.isEmpty()) {
                        continue;
                    }

                    //최댓값을 삭제하는 연산
                    if (n == 1) {
                        int max = map.lastKey();
                        int value = map.get(max);

                        if (value == 1) {
                            map.remove(max);
                        }
                        else {
                            map.put(max, value - 1);
                        }
                    }
                    //최솟값을 삭제하는 연산
                    else {
                        int min = map.firstKey();
                        int value = map.get(min);

                        if (value == 1) {
                            map.remove(min);
                        }
                        else {
                            map.put(min, value - 1);
                        }
                    }

                }
            }

            if (map.isEmpty()) {
                sb.append("EMPTY").append("\n");
                continue;
            }

            sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
        }

        System.out.print(sb);


        br.close();
    }
}
