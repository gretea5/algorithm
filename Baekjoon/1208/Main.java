import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    private static int n;
    private static int s;
    
    private static long answer;
    
    private static int[] arr;
    
    private static ArrayList<Integer> leftList;
    private static ArrayList<Integer> rightList;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());
        
        arr = new int[n];
        
        st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        answer = 0;
        
        leftList = new ArrayList<>();
        rightList = new ArrayList<>();
        
        backTrack(0, n/2, 0, leftList);
        backTrack(n/2, n, 0, rightList);
        
        Collections.sort(leftList);
        Collections.sort(rightList);
        
        int left = 0;
        int right = rightList.size() - 1;
        
        while(left < leftList.size() && right >= 0) {
            int leftValue = leftList.get(left);
            int rightValue = rightList.get(right);
            
            if (leftValue + rightValue == s) {
                long leftCnt = 0;
                long rightCnt = 0;
                
                while(left < leftList.size() && leftValue == leftList.get(left)) {
                    left += 1;
                    leftCnt += 1;
                }
                
                while(right >= 0 && rightValue == rightList.get(right)) {
                    right -= 1;
                    rightCnt += 1;
                }
                
                answer += (leftCnt * rightCnt);
            }
            else if (leftValue + rightValue > s){
                right -= 1;
            }
            else {
                left += 1;
            }
        }
        
        if (s == 0) {
            answer -= 1;
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void backTrack(int start, int end, int sum, ArrayList<Integer> list) {
        if (start == end) {
            list.add(sum);
            return;
        }
        
        backTrack(start + 1, end, sum, list);
        backTrack(start + 1, end, sum + arr[start], list);
    }
}
