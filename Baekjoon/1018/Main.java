import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static final int CHESS_BOARD_SIZE = 8;

    private static char[][] chessBoard;
    private static char[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //적절한 체스보드 초기화
        initChessBoard();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        //N, M 입력
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        //보드 배열 선언
        board = new char[N][M];

        //보드 배열 입력
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = input.charAt(j);
            }
        }

        //최소의 개수 변수
        int answer = Integer.MAX_VALUE;

        //다시 칠해야 하는 최소의 개수를 구한다.
        for (int i = 0; i <= N - CHESS_BOARD_SIZE; i++) {
            for (int j = 0; j <= M - CHESS_BOARD_SIZE; j++) {
                int cnt = calCnt(i, j);
                //왜 64에서 뺄까? 64개에서 맞는부분이 10개면 뒤집어서 보면 54개가 안 맞는 것.
                answer = Math.min(answer, Math.min(cnt, (CHESS_BOARD_SIZE * CHESS_BOARD_SIZE) - cnt));
            }
        }

        //출력
        System.out.print(answer);

        br.close();
    }

    private static int calCnt(int startX, int startY) {
        //다시 칠해야하는 개수
        int cnt = 0;

        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            for (int j = 0; j < CHESS_BOARD_SIZE; j++) {
                //체스 보드와 시작점을 더한 보드와 개수를 비교
                if (chessBoard[i][j] != board[i + startX][j + startY]) cnt += 1;
            }
        }

        return cnt;
    }

    private static void initChessBoard() {
        //배열 선언
        chessBoard = new char[CHESS_BOARD_SIZE][CHESS_BOARD_SIZE];

        //시작 문자 설정
        char ch = 'W';

        //체스 보드 만들기
        for (int i = 0; i < CHESS_BOARD_SIZE; i++) {
            for (int j = 0; j < CHESS_BOARD_SIZE; j++) {
                chessBoard[i][j] = ch;
                if (ch == 'W') ch = 'B';
                else ch = 'W';
            }
            if (ch == 'W') ch = 'B';
            else ch = 'W';
        }

    }
}
