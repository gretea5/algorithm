import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int length = s.length();

        for(int i = 0; i < length; i++) {
            if(check(s.substring(i) + s.substring(0, i)))
                answer += 1;
        }

        return answer;
    }

    public boolean check(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        char[] arr = s.toCharArray();

        for(int i = 0; i < arr.length; i++) {
            char ch = arr[i];

            if(stack.isEmpty()) {
                stack.addFirst(ch);
            }
            else {
                if(ch == ']' && stack.peekFirst() == '[') {
                    stack.removeFirst();
                }
                else if(ch == ')' && stack.peekFirst() == '(') {
                    stack.removeFirst();
                }
                else if(ch == '}' && stack.peekFirst() == '{') {
                    stack.removeFirst();
                }
                else {
                    stack.addFirst(ch);
                }
            }
        }

        return stack.isEmpty();
    }
}
