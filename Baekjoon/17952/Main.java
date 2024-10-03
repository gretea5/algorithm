import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    //숙제(점수, 소요시간, 수행시간)
    private static class Homework {
        int score;
        int spendTime;
        int doingTime;
        
        Homework(int score, int spendTime, int doingTime) {
            this.score = score;
            this.spendTime = spendTime;
            this.doingTime = doingTime;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        Homework cur = null;
        
        int n = Integer.parseInt(br.readLine());
        
        ArrayDeque<Homework> stack = new ArrayDeque<>();
        
        int answer = 0;
        
        for (int time = 1; time <= n; time++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int num = Integer.parseInt(st.nextToken());
            
            if (num == 0) {
                //cur이 null이 아니면 숙제를 하고 있다는 의미,
                if (cur != null) {
                    cur.doingTime += 1;
                    
                    //수행시간과 걸리는 시간이 동일하면 점수를 더함.
                    if (cur.doingTime == cur.spendTime) {
                        answer += cur.score;
                        
                        //점수를 더하고, 원래 하던 숙제가 있으면 하던 숙제를 한다.
                        if (!stack.isEmpty()) {
                            cur = stack.removeFirst();
                        }
                    }
                }    
                
                continue;
            }
            
            //과제가 주어졌을 경우, 점수와 소요시간을 구함
            int score = Integer.parseInt(st.nextToken());
            int spendTime = Integer.parseInt(st.nextToken());
            
            //소요시간이 1분일 경우,
            if (spendTime == 1) {
                //스택에 넣을 필요도 없이 바로 점수를 더함
                answer += score;
                continue;
            }
            
            //이전 숙제를 수행하고 있었다면, 넣기
            if (cur != null) {
                stack.addFirst(cur);
            }
            
            //최신의 숙제를 넣기
            stack.addFirst(new Homework(score, spendTime, 1));
            
            //해야할 숙제를 꺼냄
            cur = stack.removeFirst();
        }
        
        System.out.print(answer);
        
        br.close();
    }
}
