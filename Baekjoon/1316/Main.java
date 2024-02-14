import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int answer = 0;

        for(int t = 0; t < T; t++) {
            char[] arr = br.readLine().toCharArray();

            HashMap<Character, Integer> map = new HashMap<>();

            boolean flag = true;

            for(int i = 0; i < arr.length; i++) {
                //문자가 처음 들어오면 넣는다.
                if(!map.containsKey(arr[i])) {
                    map.put(arr[i], i);
                }
                else {
                    //문자에 이전에 있던 인덱스와 차이가 1이라면 이전 인덱스를 지우고 새로 넣는다.
                    if(i - map.get(arr[i]) == 1) {
                        map.remove(arr[i]);
                        map.put(arr[i], i);
                    }
                    //차이가 1이 아니라면 연속된 문자가 아니므로, 그룹 단어가 아님.
                    else {
                        flag = false;
                    }
                }
            }

            //그룹 단어라면 1을 더함
            if(flag) answer += 1;
        }

        System.out.print(answer);

        br.close();
    }
}
