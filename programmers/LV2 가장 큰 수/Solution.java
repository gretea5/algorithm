import java.util.ArrayList;
import java.util.Collections;


class Solution {
    public String solution(int[] numbers) {
        ArrayList<String> list = new ArrayList<>();
        for (int number : numbers) {
            list.add(String.valueOf(number));
        }
        Collections.sort(list, (o1, o2) -> {
            int n1 = Integer.parseInt(o1 + o2);
            int n2 = Integer.parseInt(o2 + o1);
            return Integer.compare(n2, n1);
        });
        StringBuilder sb = new StringBuilder();
        for(String str : list) {
            sb.append(str);
        }
        String answer = sb.toString();
        char c = answer.charAt(0);
        if(c == '0') {
            answer = "0";
        }
        return answer;
    }
}
