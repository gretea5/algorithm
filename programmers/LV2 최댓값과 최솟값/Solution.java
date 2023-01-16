import java.util.ArrayList; 
import java.util.Collections;
import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {        
        ArrayList<Integer> list = new ArrayList<>();
        String arr[] = s.split(" ");
        for(int i = 0; i < arr.length; i++) {
            list.add(Integer.parseInt(arr[i]));
        }
        StringBuilder sb = new StringBuilder(); 
        sb.append(Collections.min(list)).append(" ").append(Collections.max(list));
        String answer = sb.toString();
        return answer;
    }
}
