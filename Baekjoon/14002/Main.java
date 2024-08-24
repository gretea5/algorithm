import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        //가장 근 증가하는 부분 배열을 담을 arraylist
        ArrayList<Integer> list = new ArrayList<>();
        
        //초기값을 -21억 값을 넣고 시작
        list.add(Integer.MIN_VALUE);
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] arr = new int[n];
        int[] inputIdxArr = new int[n];
        
        int idx = 0;
        
        for (int i = 0; i < n; i++) {
            //배열에 값을 저장
            arr[i] = Integer.parseInt(st.nextToken());
            
            int value = arr[i];
            
            //다음수가 더 크다면 리스트에 넣는다.,
            if (list.get(list.size() - 1) < value) {
                list.add(value);
                
                //배열에 기록된 인덱스 기록 else if 문 때문에 새로운 변수를 둬야함
                inputIdxArr[i] = idx++;
            }
            //value보다 끝 값이 더 크면 넣을 자리를 찾아야함,
            else if (list.get(list.size() - 1) >= value) {
                
                //lower index 찾기
                int left = 0;
                int right = list.size() - 1;
                
                while (left <= right) {
                    int mid = (left + right) / 2;
                    
                    if (value <= list.get(mid)) {
                        right = mid - 1;
                    }
                    else {
                        left = mid + 1;
                    }
                }
                
                list.set(left, value);
                
                //여기는 있는 리스트에 삽입,
                inputIdxArr[i] = left - 1;
            }
        }
        
        //첫번째 제일 작은요소 제거
        list.remove(0);
        
        //최대 길이 -1이 가장 큰 길이 증가 수열의 길이 -1 (인덱스)
        int maxIdx = list.size() - 1;
        
        //큰 수부터 차례로 담을 스택
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        
        //삽입되는 인덱스가 maxIdx를 가지면 가장 큰 부분 수열
        for (int i = n - 1; i >= 0; i--) {
            if (inputIdxArr[i] == maxIdx) {
                stack.addFirst(arr[i]);
                
                //인덱스 -1
                maxIdx -= 1;
            }
        }
        
        //출력
        StringBuilder sb = new StringBuilder();
        
        sb.append(list.size()).append("\n");
        
        //스택에 있는 배열의 요소 출려 
        while (!stack.isEmpty()) {
            sb.append(stack.removeFirst()).append(" ");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
