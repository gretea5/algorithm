class Solution {
    public static int solution(int[] arr) {
        int answer = Integer.MIN_VALUE;

        for(int n : arr) {
            answer = Math.max(answer, n);
        }

        while(true) {
            boolean flag = true;

            for(int n : arr) {
                if(answer % n != 0) {
                    flag = false;
                }
            }

            if(flag) {
                break;
            }

            answer += 1;
        }

        return answer;
    }
}
