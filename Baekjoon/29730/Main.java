import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    private static final String BASE_URL = "boj.kr/";
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Integer> bojList = new ArrayList<>();
        ArrayList<String> subList = new ArrayList<>();
        
        int n = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            
            if (s.contains(BASE_URL)) {
                //BASE_URL을 빈공간으로 변환시키기
                s = s.replace(BASE_URL, "");
                
                //number로 파싱
                int number = Integer.parseInt(s);
                
                bojList.add(number);
            }
            else {
                subList.add(s);
            }
        }
        
        Collections.sort(subList, (s1, s2) -> {
            //길이가 같을 경우,
           if (s1.length() == s2.length()) {
               //사전순으로 정렬
               return s1.compareTo(s2);
           }
           
           //길이가 짧은순으로
           return s1.length() - s2.length();
        });
        
        //문제가 번호가 작은 순으로 정렬
        Collections.sort(bojList);
        
        StringBuilder sb = new StringBuilder();
        
        //과목 출력
        for (String sub : subList) {
            sb.append(sub).append("\n");
        }
        
        //boj 번호 출력
        for (int boj : bojList) {
            sb.append(BASE_URL);
            sb.append(boj).append("\n");
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
