import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int m;
    private static int d;
    private static int answer;

    private static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //행(세로)
        n = Integer.parseInt(st.nextToken());
        //열(가로)
        m = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        board = new int[n + 1][m + 1];

        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 1; j < m + 1; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ArrayList<Integer> attackPosList = new ArrayList<>();

        answer = Integer.MIN_VALUE;

        backTrack(attackPosList, 1, 0);

        System.out.print(answer);

        br.close();
    }

    private static void backTrack(ArrayList<Integer> attackPosList, int idx, int depth) {
        if (depth == 3) {
            //배치한 궁수로 게임을 진행
            playGame(attackPosList);

            return;
        }

        for(int i = idx; i < m + 1; i++) {
            attackPosList.add(i);

            backTrack(attackPosList, i + 1, depth + 1);

            attackPosList.remove(attackPosList.size() - 1);
        }
    }
    private static void playGame(ArrayList<Integer> attackPosList) {
        int[][] copyBoard = copyBoard();

        int count = 0;

        while(true) {
            //게임이 종료되는 경우,
            boolean isFinish = true;

            //모든적이 격자 판에서 제외되었을 경우,
            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < m + 1; j++) {
                    if (copyBoard[i][j] == 1) {
                        isFinish = false;
                        break;
                    }
                }
            }

            //종료되어야한다면,
            if (isFinish) {
                break;
            }

            boolean[][] isKilled = new boolean[n + 1][m + 1];

            for(int attackPos : attackPosList) {
                //최단 거리(적의 최단거리)
                int minDist = Integer.MAX_VALUE;

                //최단거리를 가지는 적의 위치
                int minX = -1;
                int minY = -1;

                for(int i = 1; i < n + 1; i++) {
                    for(int j = 1; j < m + 1; j++) {
                        //적이 있다면,
                        if (copyBoard[i][j] == 1) {
                            //거리를 계산
                            int dist = Math.abs((n + 1) - i) + Math.abs(attackPos - j);

                            if (minDist > dist) {
                                minDist = dist;
                                minX = i;
                                minY = j;
                            }
                            //최단 거리와 같은 경우,
                            else if (minDist == dist) {
                                //더 왼쪽에 있다면, 갱신
                                if (minY > j) {
                                    minX = i;
                                    minY = j;
                                }
                            }
                        }
                    }
                }

                if (minDist <= d) {
                    isKilled[minX][minY] = true;
                }
            }

            for(int i = 1; i < n + 1; i++) {
                for(int j = 1; j < m + 1; j++) {
                    if (isKilled[i][j]) {
                        copyBoard[i][j] = 0;
                        count += 1;
                    }
                }
            }

            //적이 아래로 한칸 이동함
            for(int i = n; i >= 1; i--) {
                for(int j = 1; j < m + 1; j++) {
                    copyBoard[i][j] = copyBoard[i - 1][j];
                }
            }
        }

        answer = Math.max(answer, count);
    }

    private static int[][] copyBoard() {
        int[][] copyBoard = new int[n + 1][m + 1];

        for(int i = 0; i < n + 1; i++) {
            copyBoard[i] = board[i].clone();
        }

        return copyBoard;
    }
}
