import java.util.ArrayDeque;

class Solution {
    public int solution(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        //문자 분리
        char[] arr = s.toCharArray();
        for(char ch : arr) {
            //스택이 비어 있을 경우
            if(stack.isEmpty()) {
                stack.addFirst(ch);
            }
            else {
                //연속된 두 문자가 왔을때,
                if(stack.peekFirst() == ch) {
                    stack.removeFirst();
                }
                //오지 않았을 때,
                else {
                    stack.addFirst(ch);
                }
            }
        }
        return stack.isEmpty() ? 1 : 0;
    }
}
