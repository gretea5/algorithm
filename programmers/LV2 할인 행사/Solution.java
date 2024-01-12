import java.util.HashMap;

class Solution {
    private static HashMap<String, Integer> wantedMap;
    private static String[] arr;

    public int solution(String[] want, int[] number, String[] discount) {
        arr = discount;
        wantedMap = new HashMap<>();

        for(int i = 0; i < want.length; i++) {
            wantedMap.put(want[i], number[i]);
        }

        int left = 0;
        int right = 9;
        int answer = 0;

        while(right != discount.length) {
            if(check(left, right)) {
                answer += 1;
            }
            left += 1;
            right += 1;
        }

        return answer;
    }

    private boolean check(int left, int right) {
        //할인 물품 기록
        HashMap<String, Integer> discountMap = new HashMap<>();

        //수량 기록
        for(int i = left; i <= right; i++) {
            discountMap.put(arr[i], discountMap.getOrDefault(arr[i], 0) + 1);
        }

        boolean flag = true;

        for(String key : wantedMap.keySet()) {
            if(wantedMap.get(key) != discountMap.get(key)) {
                flag = false;
            }
        }

        return flag;
    }
}
