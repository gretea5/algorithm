import java.util.Stack;

class Solution {
    boolean solution(String s) {
        boolean answer = true;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(') {
                stack.push(c);
            }
            else {
                if(stack.isEmpty() || stack.peek() != '(') {
                    stack.push(c);
                }
                else {
                    stack.pop();
                }
            }
        }
        if(!stack.isEmpty()) {
            answer = false;
        }
        return answer;
    }
}
