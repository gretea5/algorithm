class Solution {
    public boolean solution(String s) {
        return (s.length() == 4 || s.length() == 6) && isAllNumber(s);
    }
    public boolean isAllNumber(String s) {
        char[] arr = s.toCharArray();
        for(char ch : arr) {
            if(ch < '0' || ch > '9') {
                return false;
            }
        }
        return true;
    }
}
