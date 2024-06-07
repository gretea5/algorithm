import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    private static class Person {
        String name;
        int d;
        int m;
        int y;
        
        Person(String name, int d, int m, int y) {
            this.name = name;
            this.d = d;
            this.m = m;
            this.y = y;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Person[] arr = new Person[n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            String name = st.nextToken();
            int d = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            arr[i] = new Person(name, d, m, y);
        }
        
        Arrays.sort(arr, (p1, p2) -> {
            if (p1.y == p2.y) {
                if (p1.m == p2.m) {
                    return p1.d - p2.d;
                }
                
                return p1.m - p2.m;
            }
            
            return p1.y - p2.y;
        });
        
        System.out.println(arr[n - 1].name);
        System.out.print(arr[0].name);
        
        br.close();
    }
}
