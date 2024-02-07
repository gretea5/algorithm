import java.util.Collections;
import java.util.ArrayList;

class Solution {
    private static class Info {
        int length;
        int startIdx;
        int endIdx;

        Info(int length, int startIdx, int endIdx) {
            this.length = length;
            this.startIdx = startIdx;
            this.endIdx = endIdx;
        }
    }

    public static int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[0];

        ArrayList<Info> infoList = new ArrayList<>();

        while(true) {
            if(sum == k) {
                infoList.add(new Info(end - start, start, end));
            }

            if(start == sequence.length && end == sequence.length) break;

            if (sum <= k && end < sequence.length) {
                end += 1;

                if(end < sequence.length) sum += sequence[end];
            }
            else {
                if(start < sequence.length) sum -= sequence[start];

                start += 1;
            }
        }

        Collections.sort(infoList, (i1, i2) -> {
            if(i1.length == i2.length) {
                return i1.startIdx - i2.startIdx;
            }
            
            return i1.length - i2.length;
        });

        return new int[] { infoList.get(0).startIdx, infoList.get(0).endIdx };
    }
}
