class Solution {
    public int[] solution(String s) {
        int changeCnt = 0;
        int zeroCnt = 0;

        while(!s.equals("1")) {
            int l1 = s.length();

            //0을 제거
            s = s.replace("0", "");
            int l2 = s.length();

            //이진 문자열 변환
            s = Integer.toBinaryString(l2);

            //0의 개수와 이진 변환 횟수 계산
            zeroCnt += (l1 - l2);
            changeCnt += 1;
        }

        return new int[]{changeCnt, zeroCnt};
    }
}
