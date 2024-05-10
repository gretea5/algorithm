import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Collections;
import java.util.ArrayList;

public class Solution {
    private static class Road {
        int e1;
        int e2;
        double cost;

        Road(int e1, int e2, double cost) {
            this.e1 = e1;
            this.e2 = e2;
            this.cost = cost;
        }
    }

    private static ArrayList<Road> roadList;
    private static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        for(int test = 1; test <= t; test++) {
            int n = Integer.parseInt(br.readLine());

            parent = new int[n];

            for(int i = 0; i < n; i++) {
                parent[i] = i;
            }

            int[] xArr = new int[n];
            int[] yArr = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < n; i++) {
                xArr[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine(), " ");

            for(int i = 0; i < n; i++) {
                yArr[i] = Integer.parseInt(st.nextToken());
            }

            double e = Double.parseDouble(br.readLine());

            roadList = new ArrayList<>();

            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    int x1 = xArr[i];
                    int x2 = xArr[j];

                    int y1 = yArr[i];
                    int y2 = yArr[j];

                    double l = Math.pow(Math.abs(x2 - x1), 2) + Math.pow(Math.abs(y2 - y1), 2);

                    double cost = e * l;

                    roadList.add(new Road(i, j, cost));
                }
            }

            Collections.sort(roadList, Comparator.comparingDouble(r -> r.cost));

            double answer = 0.0;

            for(Road r : roadList) {
                if (find(r.e1) != find(r.e2)) {
                    union(r.e1, r.e2);
                    answer += r.cost;
                }
            }

            sb.append("#").append(test).append(" ");
            sb.append(Math.round(answer)).append("\n");
        }

        System.out.print(sb);

        br.close();
    }

    private static void union(int x, int y) {
        int n1 = find(x);
        int n2 = find(y);

        parent[n1] = n2;
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        parent[x] = find(parent[x]);

        return parent[x];
    }
}
