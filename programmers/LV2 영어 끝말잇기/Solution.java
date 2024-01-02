import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> set = new HashSet<>();
        int number = 0;
        int order = 0;

        //첫 문자열
        String firstWord = words[0];
        //첫 문자열 집합에 넣기
        set.add(firstWord);
        //첫 문자열 마지막 문자 꺼내기
        char lastChar = firstWord.charAt(firstWord.length() - 1);

        for(int i = 1; i < words.length; i++) {
            //문자열 꺼내기
            String word = words[i];

            //중복된 단어 사용
            if(set.contains(word) || word.charAt(0) != lastChar) {
                number = (i % n) + 1;
                order = (i / n) + 1;
                break;
            } else {
                lastChar = word.charAt(word.length() - 1);
                set.add(word);
            }
        }

        return new int[] { number, order };
    }
}
