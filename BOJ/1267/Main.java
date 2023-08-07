import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class Main {
    public static int Ymoney = 10, Ytime = 30;
    public static int Mmoney = 15, Mtime = 60;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int Ycount = 0, Mcount = 0;
        for(int time : list){
            Mcount +=  Mmoney * ((time / Mtime) + 1);
            Ycount += Ymoney * ((time / Ytime) + 1);
        }
        if (Mcount > Ycount) {
            System.out.print("Y " + Ycount);
        }
        else if(Mcount < Ycount) {
            System.out.print("M " + Mcount);
        }
        else {
            System.out.print("Y M " + Ycount);
        }
        br.close();
    }
}
