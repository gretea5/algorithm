class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;
        int l1 = 0, l2 = 0;
        for(int i = 1; i <= total / 2; i++) {
            if(total % i == 0) {
                int j = total / i;
                if(2 * (j + i - 2) == brown) {
                    l1 = Math.max(i, j);
                    l2 = Math.min(i, j);
                    break;
                }
            }
        }
        return new int[]{l1, l2};
    }
}
