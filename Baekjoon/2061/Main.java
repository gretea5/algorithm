import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.math.BigInteger;
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        BigInteger K = new BigInteger(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        String SmallerNumber = "";
        //좋은 암호일 경우 => true
        boolean flag = true;
        for(int i = 2; i < L; i++) {
            BigInteger value = BigInteger.valueOf(i);
            //L보다 작은 수 중에 나누어 떨어지는게 있다? => 나쁜암호
            if(K.remainder(value).equals(BigInteger.ZERO)) {
                //L보다 작은 수를 기록하고 flag 값을 변경
                SmallerNumber = value.toString();
                flag = false;
                break;
            }
        }
        //좋은 암호일 경우
        if(flag) {
            System.out.print("GOOD");
        }
        //나쁜 암호일 경우
        else {
            System.out.print("BAD " + SmallerNumber);
        }
        br.close();
    }
}
