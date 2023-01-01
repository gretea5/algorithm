import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new TreeSet<>();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for(int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        Iterator<Integer> itr = set.iterator();
        while(itr.hasNext()) {
            sb.append(itr.next()).append(" ");
        }
        System.out.print(sb);
        br.close();
    }
}
