class Solution {
    public int solution(int n, int a, int b) {
        int answer = 0;

        while (true) {
            if (a == b) {
                break;
            }

            a = nextRound(a);
            b = nextRound(b);

            answer += 1;
        }

        return answer;
    }

    private int nextRound(int num) {
        return num % 2 == 1 ? (num / 2) + 1 : num / 2;
    }
}
