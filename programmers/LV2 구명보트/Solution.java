import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length - 1;
        int answer = 0;

        while(left <= right) {
            if(people[left] + people[right] > limit) {
                right -= 1;
                answer += 1;
            } else {
                left += 1;
                right -= 1;
                answer += 1;
            }
        }

        return answer;
    }
}
