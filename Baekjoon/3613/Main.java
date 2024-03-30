import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        //맨 앞이나 맨 뒤에 _이 붙을 경우,
        if(str.charAt(0) == '_' || str.charAt(str.length() - 1) == '_') {
            System.out.print("Error!");
            return;
        }

        //__이 두번 연속으로 붙을 경우
        if (str.contains("__")) {
            System.out.print("Error!");
            return;
        }

        //첫번째 문자가 대문자일 경우,
        if (checkUpperCase(String.valueOf(str.charAt(0)))) {
            System.out.print("Error!");
            return;
        }

        //단어에 공백이 존재할 경우,(모든 단어가 붙어 있지 않은 경우)
        if (str.contains(" ")) {
            System.out.print("Error!");
            return;
        }

        //둘다 포함이 되어 있는 경우,
        if (checkUpperCase(str) && str.contains("_")) {
            System.out.print("Error!");
            return;
        }

        StringBuilder sb = new StringBuilder();

        //_이 포함되거나 모두 소문자 일경우,(C++)
        if (str.contains("_") || !checkUpperCase(str)) {
            String[] arr = str.split("_");

            for(int i = 0; i < arr.length; i++) {
                if (i != 0) {
                    //첫문자 빼기
                    char ch = arr[i].charAt(0);
                    //대문자 변환
                    String upperStr = String.valueOf(ch).toUpperCase();

                    //대문자 붙이고, 나머지 문자 붙인다.
                    sb.append(upperStr).append(arr[i].substring(1));
                }
                //첫번재 문자일 경우 대문자로 변환하지 않는다.
                else {
                    sb.append(arr[i]);
                }
            }
        }
        //대문자가 존재할 경우(Java)
        else if (checkUpperCase(str)) {
            for(char ch : str.toCharArray()) {
                //대문자 일 경우 _를 앞에 붙이고 소문자를 붙여준다.
                if ('A' <= ch && ch <= 'Z') {
                    String lowerStr = String.valueOf(ch).toLowerCase();

                    sb.append("_").append(lowerStr);
                }
                //소문자일경우, 그냥 붙인다.
                else {
                    sb.append(ch);
                }
            }
        }

        System.out.print(sb);

        br.close();
    }

    private static boolean checkUpperCase(String str) {
        for(char ch : str.toCharArray()) {
            if ('A' <= ch && ch <= 'Z') {
                return true;
            }
        }

        return false;
    }
}
