import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // TC 개수
        int n = Integer.parseInt(st.nextToken());
        
        // 도화지.
        int[][] arr = new int[1002][1002];
        
        //100 * 1000 * 1000 = 1억(1초)
        //T개를 받으면서 붙여가는거 잖아..
        
        //100번
        for(int t = 1; t <= n; t++) {
            st = new StringTokenizer(br.readLine());
            
            int leftX = Integer.parseInt(st.nextToken()); // 왼쪽 아래 x.
            int leftY = Integer.parseInt(st.nextToken()); // 왼쪽 아래 y.
            int dx = Integer.parseInt(st.nextToken()); // 너비.
            int dy = Integer.parseInt(st.nextToken()); // 높이.
            
            //덮어써도 써질꺼야..
            //1000번
            for (int i = leftX; i < leftX+dx; i++) {
                
                //1000번
                for(int j = leftY; j < leftY+dy; j++) {
                    arr[i][j] = t;
                }
            }
        }
        
        // 각 색종이의 면적 배열
        int[] countArr = new int[n + 1];
        
        //(10만)
        for(int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                countArr[arr[i][j]] += 1;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for(int c = 1; c < countArr.length; c++) {
            sb.append(countArr[c]).append("\n");
        }
        
        System.out.print(sb);
    }

}
