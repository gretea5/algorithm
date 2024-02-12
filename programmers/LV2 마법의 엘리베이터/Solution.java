class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        while(storey != 0) {
            //자리수
            int num = storey % 10;
            //10을 나눔
            storey /= 10;
            
            if(num == 5) {
                if(storey % 10 >= 5) {
                    answer += (10 - num);
                    storey += 1;
                }
                else {
                    answer += num;
                }
            }
            else if(num > 5) {
                answer += (10 - num);
                storey += 1;
            }
            else {
                answer += num;
            }
        }
        
        return answer;
    }
}
