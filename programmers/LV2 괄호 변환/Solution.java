import java.util.ArrayDeque;

class Solution {
    public String solution(String p) {
        return makeStr(p);
    }

    private static String makeStr(String w) {
        if(w.isEmpty()) {
            return "";
        }

        String u = "";
        String v = "";

        for(int i = 1; i <= w.length(); i++) {
            if(checkBalance(w.substring(0, i)) && checkBalance(w.substring(i))) {
                u = w.substring(0, i);
                v = w.substring(i);
                break;
            }
        }

        if(checkCorrect(u)) {
            return u + makeStr(v);
        }
        else {
            return "(" + makeStr(v) + ")" + makeReverseStr(u);
        }

    }

    private static String makeReverseStr(String str) {
        str = str.substring(1, str.length() - 1);

        StringBuilder sb = new StringBuilder();

        for(char ch : str.toCharArray()) {
            if(ch == '(') {
                sb.append(')');
            }
            else {
                sb.append('(');
            }
        }

        return sb.toString();
    }

    private static boolean checkBalance(String str) {
        int cnt = 0;

        for(char ch : str.toCharArray()) {
            if(ch == '(') cnt += 1;
        }

        return str.length() - cnt == cnt;
    }

    private static boolean checkCorrect(String str) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for(int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if(ch == '(')  {
                stack.addFirst(ch);
            }
            else {
                if(!stack.isEmpty() && stack.peekFirst() == '(') {
                    stack.removeFirst();
                }
            }

        }

        return stack.isEmpty();
    }
}
