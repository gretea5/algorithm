import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    private static int answer;
    
    private static int[][] map;
    private static int[][] copyMap;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        n = Integer.parseInt(br.readLine());
        
        map = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        answer = Integer.MIN_VALUE;
        
        for(int a = 0; a < 4; a++) {
            for(int b = 0; b < 4; b++) {
                for(int c = 0; c < 4; c++) {
                    for(int d = 0; d < 4; d++) {
                        for(int e = 0; e < 4; e++) {
                            copyMap = createCopyMap();
                            
                            rotate(copyMap, a);
                            rotate(copyMap, b);
                            rotate(copyMap, c);
                            rotate(copyMap, d);
                            rotate(copyMap, e);
                            
                            answer = Math.max(answer, calMax(copyMap));
                        }
                    }
                }
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void rotate(int[][] arr, int dir) {
        int[][] copyArr = new int[n][n];
        
        //위로 밀기
        if (dir == 0) {
            for(int i = 0; i < n; i++) {
                int idx = 0;
                int block = 0;
                for(int j = 0; j < n; j++) {
                    //빈칸이 아닐때,
                    if (arr[j][i] != 0) {
                        //빈칸이 아니면서, 최근 블록의 숫자와 다음 숫자가 다를때,
                        if (block != arr[j][i]) {
                            copyArr[idx][i] = arr[j][i];
                            block = arr[j][i];
                            arr[j][i] = 0;
                            idx += 1;
                        }
                        //현재 수와 다음 수가 같다면,
                        else {
                            copyArr[idx - 1][i] = block * 2;
                            block = 0;
                            arr[j][i] = 0;
                        }
                    }
                }
            }
        }
        //아래로 밀기
        else if (dir == 1) {
            for(int i = 0; i < n; i++) {
                int idx = n - 1;
                int block = 0;
                for(int j = n - 1; j >= 0; j--) {
                    if (arr[j][i] != 0) {
                        //빈칸이 아니면서, 최근 블록의 숫자와 다음 숫자가 다를때,
                        if (block != arr[j][i]) {
                            copyArr[idx][i] = arr[j][i];
                            block = arr[j][i];
                            arr[j][i] = 0;
                            idx -= 1;
                        }
                        //현재 수와 다음 수가 같다면,
                        else {
                            copyArr[idx + 1][i] = block * 2;
                            block = 0;
                            arr[j][i] = 0;
                        }
                    }
                }
            }
        }
        //오른쪽으로 밀기
        else if (dir == 2) {
            for(int i = 0; i < n; i++) {
                int idx = n - 1;
                int block = 0;
                for(int j = n - 1; j >= 0; j--) {
                    //빈칸이라면
                    if(arr[i][j] != 0) {
                        //블록 값과 현재 배열의 값이 다르다면,
                        if (block != arr[i][j]) {
                            copyArr[i][idx] = arr[i][j];
                            block = arr[i][j];
                            arr[i][j] = 0;
                            idx -= 1;
                        }
                        //블록의 값과 현재 배열의 값이 같다면,
                        else {
                            copyArr[i][idx + 1] = block * 2;
                            block = 0;
                            arr[i][j] = 0;
                        }
                    }
                }
            }
        }
        //왼쪽으로 밀기
        else {
            for(int i = 0; i < n; i++) {
                int idx = 0;
                int block = 0;
                for(int j = 0; j < n; j++) {
                    //빈칸이라면
                    if(arr[i][j] != 0) {
                        //블록 값과 현재 배열의 값이 다르다면,
                        if (block != arr[i][j]) {
                            copyArr[i][idx] = arr[i][j];
                            block = arr[i][j];
                            arr[i][j] = 0;
                            idx += 1;
                        }
                        //블록의 값과 현재 배열의 값이 같다면,
                        else {
                            copyArr[i][idx - 1] = block * 2;
                            block = 0;
                            arr[i][j] = 0;
                        }
                    }
                }
            }
        }
        
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = copyArr[i][j];
            }
        }
    }
    
    private static int calMax(int[][] arr) {
        int max = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                max = Math.max(arr[i][j], max);
            }
        }
        
        return max;
    }
    
    private static int[][] createCopyMap() {
        int[][] arr = new int[n][n];
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                arr[i][j] = map[i][j];
            }
        }
        
        return arr;
    }
}
