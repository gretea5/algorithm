import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < N; i++) {
            set.add(br.readLine());
        }
        String strArr[] = new String[set.size()];
        Iterator<String> itr = set.iterator();
        for(int i = 0; i < strArr.length; i++) {
            strArr[i] = itr.next();
        }
        Arrays.sort(strArr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                if(s1.length() == s2.length()) {
                    return (s1.compareTo(s2));
                }
                return s1.length() - s2.length();
            }
        });
        for(String s : strArr) {
            System.out.println(s);
        }
        br.close();
    }
}
