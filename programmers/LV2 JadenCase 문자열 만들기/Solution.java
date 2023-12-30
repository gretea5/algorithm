import java.util.StringTokenizer;

class Solution {
    public String solution(String s) {
        StringTokenizer st = new StringTokenizer(s, " ", true);
        StringBuilder sb = new StringBuilder();
        while(st.hasMoreTokens()) {
            String str = st.nextToken();
            if(str.equals(" ")) {
                sb.append(" ");
            } else {
                sb.append(str.substring(0, 1).toUpperCase())
                        .append(str.substring(1).toLowerCase());
            }
        }
        return sb.toString();
    }
}
