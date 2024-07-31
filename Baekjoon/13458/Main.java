import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        int[] persons = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < n; i++) {
            persons[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        
        long answer = n;
        
        for(int person : persons) {
            //이미 답의 총 감독관의 개수가 있으므로 총 감독관의 감시할 수 있는 사람들을 빼줌
            person -= b;
            
            //부 감독관의 감시가 필요할 경우
            if (person > 0) {
                //부감독관의 개수
                int coach = person / c;
            
                //C보다 작은 그룹이 하나 있을 경우 부감독관이 붙어야함
                if (person % c > 0) {
                    coach += 1;
                }
                
                answer += coach;
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
