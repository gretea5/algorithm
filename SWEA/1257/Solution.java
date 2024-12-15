import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    private static class Trie {
        HashMap<Character, Trie> map;
        char value;
        int cnt;
        boolean isEnd;

        Trie() {
            map = new HashMap<>();
            value = ' ';
            cnt = 0;
            isEnd = false;
        }
    }

    private static int k;
    private static String answer;

    private static char[] results;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            k = Integer.parseInt(br.readLine());
            String s = br.readLine();

            int sLength = s.length();

            Trie head = new Trie();

            HashSet<String> set = new HashSet<>();

            for (int i = 0; i < sLength; i++) {
                insert(head, s, i);
            }

            results = new char[sLength];

            answer = "none";

            dfs(head, 0);

            sb.append(answer);
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static int insert(Trie cur, String s, int idx) {
        if (idx == s.length()) {
            return 0;
        }

        //이 문제는 개수의 이슈가 있는거지 중복을 체크해야하는거니까, 그리고 루트의 하단은 전부 끝인 노드가 되게끔 만들면 되는겨
        char curValue = s.charAt(idx);

        //현재 노드에서 자식으로 가지는 단어들의 개수
        int childCount = 0;

        //노드가 생성되지 않았으면,
        if (!cur.map.containsKey(curValue)) {
            Trie next = new Trie();

            next.isEnd = true;

            cur.map.put(curValue, next);

            //자식 노드 생성 개수를 1을 구함
            childCount = 1;
        }
        
        Trie next = cur.map.get(curValue);

        childCount += insert(next, s, idx + 1);

        next.cnt += childCount;

        cur.map.put(curValue, next);

        return childCount;
    }

    private static void dfs(Trie cur, int depth) {
        if (k == 0) return;

        if (cur.isEnd) {
            k -= 1;

            //원하는 문자를 만났을때,
            if (k == 0) {
                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < depth; i++) {
                    builder.append(results[i]);
                }

                answer = builder.toString();

                return;
            }
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (cur.map.containsKey(ch)) {
                Trie next = cur.map.get(ch);

                if (k > next.cnt) {
                    k -= next.cnt;
                    continue;
                }

                results[depth] = ch;
                dfs(cur.map.get(ch), depth + 1);
                results[depth] = ' ';
            }
        }
    }
}
