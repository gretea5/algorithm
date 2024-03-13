import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int[][] colors;
    private static boolean[][] visited;

    private static int whiteNumber, blueNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력
        int N = Integer.parseInt(br.readLine());

        //배열 선언
        colors = new int[N][N];
        visited = new boolean[N][N];


        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            //색종이 정보 입력
            for(int j = 0; j < N; j++) {
                colors[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //하얀색, 파란색 색종이 개수
        whiteNumber = blueNumber = 0;

        //초기 길이
        int len = N;

        while(len > 0) {
            for(int i = 0; i < N; i += len) {
                for(int j = 0; j < N; j += len) {
                    if(!visited[i][j]) {
                        check(i, j, colors[i][j], len);
                    }
                }
            }
            len /= 2;
        }

        System.out.print(whiteNumber + "\n" + blueNumber);

        br.close();
    }

    private static void check(int x, int y, int color, int length) {
        boolean flag = true;

        for(int i = x; i < x + length; i++) {
            for(int j = y; j < y + length; j++) {
                if(color != colors[i][j]) {
                    flag = false;
                    break;
                }
            }
        }

        if(flag) {
            //영역을 방문처리
            for(int i = x; i < x + length; i++) {
                for(int j = y; j < y + length; j++) {
                    visited[i][j] = true;
                }
            }

            if(color == 1) {
                blueNumber += 1;
            }
            else {
                whiteNumber += 1;
            }
        }
    }
}
