class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        //i: 자를 문자의 개수
        for(int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            
            //맨 앞부터 i개 만큼 자르기
            String initStr = s.substring(0, i);
            //갯수는 초기 1개
            int count = 1;
            
            for(int j = i; j <= s.length(); j += i) {
                //이걸 왜 했을까? 문자열의 인덱스가 j + n * i처럼 나누어 떨어지지 않을 경우가 있기 때문,
                int endIdx = Math.min(j + i, s.length());
                
                //j부터 endIdx까지 문자열을 자른다.
                String divStr = s.substring(j, endIdx);
                
                //즉 다음번째 i만큼 자른 경우가 동일할 경우 count를 1 증가
                if(initStr.equals(divStr)) {
                    count += 1;
                }
                else {
                    //동일한 문자열이 1개 보다 많다면,
                    if(count > 1) {
                        sb.append(count);
                    }
                    //그 다음 문자열을 붙임
                    sb.append(initStr);
                    
                    //압축된 뒤 나머지 자른 문자열
                    initStr = divStr;
                    
                    //초기 개수를 1로 초기화
                    count = 1;
                }
            }
            
            sb.append(initStr);
            
            answer = Math.min(answer, sb.toString().length());
        }
        return answer;
    }
}
