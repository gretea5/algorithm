import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Solution {
    private static class Trie {
        HashMap<Character, Trie> map;
        char value;
        boolean isEnd;
        int count;

        Trie() {
            map = new HashMap<>();
            value = ' ';
            isEnd = false;
            count = 0;
        }
    }

    private static char[] result;
    private static int k;
    private static String answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for (int test = 1; test <= t; test++) {
            sb.append("#").append(test).append(" ");

            k = Integer.parseInt(br.readLine());
            String s = br.readLine();

            result = new char[s.length()];

            //루트 노드 생성
            Trie head = new Trie();

            answer = "none";

            for (int i = 0; i < s.length(); i++) {
                insert(head, s.substring(i));
            }

            dfs(head, 0);

            sb.append(answer);
            sb.append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void insert(Trie head, String s) {
        Trie cur = head;

        for (char ch : s.toCharArray()) {
            //ch에 해당하는 HashMap이 없다면 새로 생성해서 넣어줌
            if (!cur.map.containsKey(ch)) {
                Trie newObj = new Trie();

                cur.map.put(ch, newObj);
            }

            //다음 트라이 노드 가져오기
            Trie next = cur.map.get(ch);

            //다음 트라이 노드에 값을 넣어주기
            next.value = ch;
            next.count += 1;

            cur.map.put(ch, next);

            //다음 노드로 움직임
            cur = next;
        }

        cur.isEnd = true;
    }

    private static void dfs(Trie cur, int depth) {
        if (k == 0) return;

        if (cur.isEnd) {
            k -= 1;

            //원하는 문자를 찾았을 경우,
            if (k == 0) {
                StringBuilder builder = new StringBuilder();

                for (int i = 0; i < depth; i++) {
                    builder.append(result[i]);
                }

                answer = builder.toString();

                return;
            }
        }

        for (char ch = 'a';  ch <= 'z'; ch++) {
            //ch에 해당하는 트라이가 있다면,
            if (cur.map.containsKey(ch)) {
                Trie next = cur.map.get(ch);

                result[depth] = ch;
                dfs(next, depth + 1);
                result[depth] = ' ';
            }
        }
    }
}
