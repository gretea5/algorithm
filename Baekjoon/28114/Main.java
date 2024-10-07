import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    private static class Person {
        int solvedCount;
        int inputYear;
        String name;
        
        Person(int solvedCount, int inputYear, String name) {
            this.solvedCount = solvedCount;
            this.inputYear = inputYear;
            this.name = name;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        ArrayList<Person> pList = new ArrayList<>();
        
        for (int i = 0; i < 3; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            int solvedCount = Integer.parseInt(st.nextToken());
            int inputYear = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            pList.add(new Person(solvedCount, inputYear, name));
        }
        
        ArrayList<Integer> mulYearList = new ArrayList<>();
        
        for (Person p : pList) {
            mulYearList.add(p.inputYear % 100);
        }
        
        Collections.sort(mulYearList);
        
        StringBuilder sb = new StringBuilder();
        
        for (int year : mulYearList) {
            sb.append(year);
        }
        
        sb.append("\n");
        
        Collections.sort(pList, (p1, p2) -> p2.solvedCount - p1.solvedCount);
        
        for (Person p : pList) {
            sb.append(p.name.charAt(0));
        }
        
        System.out.print(sb);
        
        br.close();
    }
}
