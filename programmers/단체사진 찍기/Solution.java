import java.util.HashMap;

class Solution {
    private final int NUMBER = 8;
    private int answer;
    
    //캐릭터의 사용 여부
    private boolean[] visited;
    
    private String[] command;
    
    //캐릭터가 들어간 인덱스를 저장하는 hashMap
    private HashMap<Character, Integer> idxMap;
    
    private final char[] charArr = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    
    public int solution(int n, String[] data) {
        command = data;
        
        init();
        
        backTrack(0);
        
        return answer;
    }
    
    private void init() {
        answer = 0;
        
        idxMap = new HashMap<>();
        visited = new boolean[NUMBER];
    }
    
    private void backTrack(int depth) {
        if (depth == NUMBER) {
            if (check()) {
                answer += 1;
            }
            
            return;
        }
        
        for (int i = 0; i < NUMBER; i++) {
            if (visited[i]) continue;
            
            idxMap.put(charArr[i], depth);
            visited[i] = true;
            
            backTrack(depth + 1);
            
            idxMap.remove(charArr[i]);
            visited[i] = false;
        }
    }
    
    private boolean check() {
        for (String s : command) {
            char c1 = s.charAt(0);
            char c2 = s.charAt(2);
            
            int p1 = idxMap.get(c1);
            int p2 = idxMap.get(c2);
            
            //두 캐릭터의 간격
            int dist = Math.abs(p1 - p2) - 1;
            
            char oper = s.charAt(3);
            //캐릭터가 원하는 간격
            int interval = s.charAt(4) - '0';
            
            if (oper == '=') {
                if (dist != interval) {
                    return false;
                }
            }
            else if (oper == '>') {
                if (dist <= interval) {
                    return false;
                }
            }
            else if (oper == '<') {
                if (dist >= interval) {
                    return false;
                }
            }
        }
        
        return true;
    }
}
