import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException{
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      
      int n = Integer.parseInt(br.readLine());
      
      String strArr[] = new String[n];
     
      for(int i = n - 1; i >= 0; i--){
        String temp = "";
        for(int j = 0; j < 2 * n - i - 1; j++){
            if(j < i) temp += " ";
            else temp += "*";
        }
        strArr[n - 1 - i] = temp;
        System.out.println(temp);
      }
    
       for(int i = n - 2; i >= 0; i--){
          System.out.println(strArr[i]);
      }
    }
}
