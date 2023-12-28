import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collections;

public class Main {
    public static int cities, roads, distance, startCity;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static ArrayList<Integer> ansList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        cities = Integer.parseInt(st.nextToken());
        roads = Integer.parseInt(st.nextToken());
        distance = Integer.parseInt(st.nextToken());
        startCity = Integer.parseInt(st.nextToken());
        visited = new boolean[cities + 1];
        for(int i = 0; i < cities + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < roads; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            graph.get(Integer.parseInt(st.nextToken())).add(Integer.parseInt(st.nextToken()));
        }
        bfs(startCity, distance);
        Collections.sort(ansList);
        if(ansList.isEmpty()) {
            System.out.print(-1);
            return;
        }
        else {
            for(int v : ansList) {
                System.out.println(v);
            }
        }
        br.close();
    }
    public static void bfs(int startCity, int distance) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{startCity, 0});
        visited[startCity] = true;
        while(!q.isEmpty()) {
            int[] curInfo = q.poll();
            int curCity = curInfo[0];
            int curDistance = curInfo[1];
            if (curDistance == distance) {
                ansList.add(curCity);
            }
            for(int i = 0; i < graph.get(curCity).size(); i++) {
                int y = graph.get(curCity).get(i);
                if(!visited[y]) {
                    q.offer(new int[]{y, curDistance + 1});
                    visited[y] = true;
                }
            }
        }
    }
}
