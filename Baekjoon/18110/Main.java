import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        if (n == 0) {
            System.out.print(0);
            return;
        }
        
        int[] arr = new int[n];
        
        //배열 입력
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        
        //오름차순 정렬
        Arrays.sort(arr);
        
        //제외 개수(15%)
        int exceptNumber = (int) Math.round(n * 0.15);
        
        //제외하고 나머지 합
        double sum = 0.0;
        
        //합 구하기
        for(int i = exceptNumber; i < n - exceptNumber; i++) {
            sum += arr[i];
        }
        
        //30% 수를 제외한 나머지 평균을 구한다.
        int answer = (int) Math.round(sum / (n - (exceptNumber * 2)));
        
        //출력
        System.out.print(answer);
        
        br.close();
    }
}
