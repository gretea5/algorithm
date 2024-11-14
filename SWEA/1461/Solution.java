/* swea: 프로세서 연결하기 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

class Solution {
    private static class Pos {
        int x;
        int y;

        Pos(int x, int y) {
        this.x = x;
        this.y = y;
        }
    }

    private static class AnsData {
        int connectCnt;
        int lineCnt;

        AnsData(int connectCnt, int lineCnt) {
            this.connectCnt = connectCnt;
            this.lineCnt = lineCnt;
        }
    }

    private static int n;
    private static int maxConnectCnt;
    private static int answer;

    private static int[][] map;

    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};

    private static ArrayList<Pos> coreList;

    private static final int LINE = -1;
    private static final int BLANK = 0;
    private static final int CORE = 1;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= tc; test++) {
            sb.append("#").append(test).append(" ");

            n = Integer.parseInt(br.readLine());

            map = new int[n][n];
            coreList = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine(), " ");

                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());

                    if (i == 0 || i == n - 1) {
                        continue;
                    }

                    if (j == 0 || j == n - 1) {
                        continue;
                    }

                    //코어를 담음
                    if (map[i][j] == CORE) {
                        coreList.add(new Pos(i, j));
                    }
                }
            }

            maxConnectCnt = Integer.MIN_VALUE;
            answer = Integer.MAX_VALUE;

            backTrack(0, 0, 0, 0);

            sb.append(answer);
            sb.append("\n");
        }
        
        System.out.print(sb);

        br.close();
    }

    private static void backTrack(int idx, int depth, int connectCnt, int lineCnt) {
        if (maxConnectCnt <= connectCnt) {
            if (maxConnectCnt < connectCnt) {
                //최대 core 기록 횟수 갱신
                maxConnectCnt = connectCnt;

                // 연결 횟수 초기화
                answer = Integer.MAX_VALUE;
            }

            answer = Math.min(answer, lineCnt);
        }

        if (idx >= coreList.size()) {
            return;
        }

        //현재 core 연결 안할 경우 고려,
        backTrack(idx + 1, depth + 1, connectCnt, lineCnt);

        Pos core = coreList.get(idx);

        int coreX = core.x;
        int coreY = core.y;

        for (int i = 0; i < 4; i++) {
            if (checkLine(coreX, coreY, i)) {
                writeMap(coreX, coreY, i, LINE);

                int cnt = calLineCnt(coreX, coreY, i);

                backTrack(idx + 1, depth + 1, connectCnt + 1, lineCnt + cnt);

                writeMap(coreX, coreY, i, BLANK);
            }
        }
    }

    private static boolean checkLine(int x, int y, int dir) {
        int mx = x;
        int my = y;

        while (true) {
            mx += dx[dir];
            my += dy[dir];

            if (mx < 0 || mx >= n || my < 0 || my >= n) break;

            //코어나 선을 만났으면 이을 수 없음
            if (map[mx][my] == CORE || map[mx][my] == LINE) {
                return false;
            }
        }

        return true;
    }

    private static void writeMap(int x, int y, int dir, int value) {
        int mx = x;
        int my = y;

        while (true) {
            mx += dx[dir];
            my += dy[dir];

            if (mx < 0 || mx >= n || my < 0 || my >= n) break;

            map[mx][my] = value;
        }
    }

    private static int calLineCnt(int x, int y, int dir) {
        int mx = x;
        int my = y;

        int cnt = 0;

        while (true) {
            mx += dx[dir];
            my += dy[dir];

            if (mx < 0 || mx >= n || my < 0 || my >= n) break;

            cnt += 1;
        }

        return cnt;
    }
}
