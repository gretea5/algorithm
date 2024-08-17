import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
    private static class Processor {
        int x;
        int y;

        Processor(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    private static class Info {
        int recordCnt;
        int number;

        Info(int recordCnt, int number) {
            this.recordCnt = recordCnt;
            this.number = number;
        }
    }

    private static int n;
    private static int answer;
    private static int maxRecord;

    private static ArrayList<Processor> pList;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for (int test = 1; test <= t; test++) {
            n = Integer.parseInt(br.readLine());

            int[][] map = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            pList = new ArrayList<>();

            //프로세서에 대한 정보를 넣기
            for (int i = 1; i < n - 1; i++) {
                for (int j = 1; j < n - 1; j++) {
                    if (map[i][j] == 1) {
                        pList.add(new Processor(i, j));
                    }
                }
            }

            maxRecord = Integer.MIN_VALUE;
            answer = Integer.MAX_VALUE;

            backTrack(map, 0, 0, 0);

            sb.append("#").append(test).append(" ");
            sb.append(answer).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void backTrack(int[][] map, int idx, int depth, int recordCnt) {
        if (depth == pList.size()) {
            if (maxRecord <= recordCnt) {
                //maxRecord가 더 크면 갱신해준다.
                if (maxRecord < recordCnt) {
                    maxRecord = recordCnt;
                    answer = Integer.MAX_VALUE;
                }

                //같은 경우,
                int sum = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < n; j++) {
                        if (map[i][j] == -1) {
                            sum += 1;
                        }
                    }
                }

                answer = Math.min(answer, sum);
            }

            return;
        }

        Processor p = pList.get(idx);

        for (int d = 0; d < 4; d++) {
            if (check(map, p.x, p.y, d)) {
                record(map, p.x, p.y, d);

                backTrack(map, idx + 1, depth + 1, recordCnt + 1);

                unRecord(map, p.x, p.y, d);
            }
        }

        backTrack(map, idx + 1, depth + 1, recordCnt);
    }

    private static void record(int[][] map, int x, int y, int dir) {
        int mx = x;
        int my = y;

        while (true) {
            mx += dx[dir];
            my += dy[dir];

            // -1 기록
            map[mx][my] = -1;

            if (mx == 0 || mx == n - 1 || my == 0 || my == n - 1) {
                break;
            }
        }
    }

    private static void unRecord(int[][] map, int x, int y, int dir) {
        int mx = x;
        int my = y;

        while (true) {
            mx += dx[dir];
            my += dy[dir];

            // 0 기록
            map[mx][my] = 0;

            if (mx == 0 || mx == n - 1 || my == 0 || my == n - 1) {
                break;
            }
        }
    }

    private static boolean check(int[][] map, int x, int y, int dir) {
        int mx = x;
        int my = y;

        while (true) {
            mx += dx[dir];
            my += dy[dir];

            //프로세서나 전깃줄로 막혀있으면, break
            if (map[mx][my] == 1 || map[mx][my] == -1) {
                break;
            }

            if (mx == 0 || mx == n - 1 || my == 0 || my == n - 1) {
                return true;
            }
        }

        return false;
    }
}
