import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    private static class CCTV {
        int num;
        int x;
        int y;

        CCTV(int num, int x, int y) {
            this.num = num;
            this.x = x;
            this.y = y;
        }
    }

    private static int n;
    private static int m;
    private static int answer;

    private static final int[] dx = {1, 0, -1, 0};
    private static final int[] dy = {0, 1, 0, -1};

    private static ArrayList<CCTV> cctvList;
    private static ArrayList<Integer>[] dirList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        dirList = new ArrayList[6];

        for(int i = 0; i < 6; i++) {
            dirList[i] = new ArrayList<>();
        }

        //cctv 방향 인덱스 넣기
        dirList[1].add(0);

        dirList[2].add(0);
        dirList[2].add(2);

        dirList[3].add(0);
        dirList[3].add(1);

        dirList[4].add(0);
        dirList[4].add(1);
        dirList[4].add(2);

        dirList[5].add(0);
        dirList[5].add(1);
        dirList[5].add(2);
        dirList[5].add(3);

        cctvList = new ArrayList<>();

        int[][] board = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                //cctv 정보 저장
                if (1 <= board[i][j] && board[i][j] <= 5) {
                    cctvList.add(new CCTV(board[i][j], i, j));
                }
            }
        }

        answer = Integer.MAX_VALUE;

        backTrack(0, board);

        System.out.print(answer);

        br.close();
    }

    private static void backTrack(int idx, int[][] board) {
        //깊이가 cctv 개수가 같다면 => 사각 지대의 최소 크기를 구한다.
        if (idx == cctvList.size()) {
            int cnt = 0;

            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if (board[i][j] == 0) {
                        cnt += 1;
                    }
                }
            }

            answer = Math.min(answer, cnt);

            return;
        }

        //cctv 정보 가져오기
        CCTV c = cctvList.get(idx);

        int cctvNum = c.num;
        int x = c.x;
        int y = c.y;

        //4번 로테이션 (1~5번 cctv에서 방향을 다 더해서 기록을 해주면 된다.)
        for(int d = 0; d < 4; d++) {
            //인자로 넘어온 board를 복사해서 가져옴
            int[][] copy = copyBoard(board);

            //감시할 방향을 체크해주기(cctv 방향이 들어있음)
            for(int j = 0; j < dirList[cctvNum].size(); j++) {
                //방향 인덱스를 가져옴
                int dir = dirList[cctvNum].get(j);

                //방향을 회전
                dir = (dir + d) % 4;

                int curX = x;
                int curY = y;

                while(true) {
                    //감시할 방향을 기록
                    curX += dx[dir];
                    curY += dy[dir];

                    //벽이 있을 경우나 영역 밖으로 나갈 경우, 빠져나간다.
                    if (curX < 0 || curX >= n || curY < 0 || curY >= m || board[curX][curY] == 6) {
                        break;
                    }
                        
                    //기존에 있던 cctv에도 접근이 될 수 있으므로, 0일때만 -1 접근
                    if (copy[curX][curY] == 0) {
                        copy[curX][curY] = -1;
                    }
                }
            }

            //기록된 배열을 인자로 넘겨서 복사하면서 사용
            backTrack(idx + 1, copy);
        }
    }

    //배열을 복사해주는 메소드
    private static int[][] copyBoard(int[][] origin) {
        int[][] copy = new int[n][m];

        for(int i = 0; i < n; i++) {
            copy[i] = origin[i].clone();
        }

        return copy;
    }
}
