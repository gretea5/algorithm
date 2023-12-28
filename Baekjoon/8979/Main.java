import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
public class Main {
    private static class Nation {
        int num;
        int gold;
        int silver;
        int bronze;
        int rate;
        Nation(int num, int gold, int silver, int bronze, int rate) {
            this.num = num;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
            this.rate = rate;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        ArrayList<Nation> arr = new ArrayList<>();
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int num = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());
            arr.add(new Nation(num, gold, silver, bronze, 0));
        }
        Collections.sort(arr, (o1, o2) -> {
            if (o1.gold == o2.gold) {
                if (o1.silver == o2.silver) {
                    return o2.bronze - o1.bronze;
                } else {
                    return o2.silver - o1.silver;
                }
            } else {
                return o2.gold - o1.gold;
            }
        });
        int targetNation = 0;
        arr.get(0).rate = 1;
        for(int i = 1; i < arr.size(); i++) {
            int beforeGold = arr.get(i - 1).gold;
            int beforeSilver = arr.get(i - 1).silver;
            int beforeBronze = arr.get(i - 1).bronze;
            int beforeRate = arr.get(i - 1).rate;
            if(arr.get(i).num == K) {
                targetNation = i;
            }
            if(arr.get(i).gold == beforeGold && arr.get(i).silver == beforeSilver && arr.get(i).bronze == beforeBronze) {
                arr.get(i).rate = beforeRate;
            }
            else {
                arr.get(i).rate = i + 1;
            }
        }
        System.out.print(arr.get(targetNation).rate);
        br.close();
    }
}g
