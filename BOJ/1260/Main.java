import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class Main {
    public static int numOfEdges;
    public static int numOfVertexes;
    public static int startVertex;
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static boolean visited[];
    public static void dfs(int x) {
        visited[x] = true;
        System.out.print(x + " ");
        for(int i = 0; i < graph.get(x).size(); i++) {
            if(!visited[graph.get(x).get(i)]) {
                dfs(graph.get(x).get(i));
            }
        }
    }
    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        while(true) {
            if(q.isEmpty()) break;
            int v = q.poll();
            System.out.print(v + " ");
            for(int i = 0; i < graph.get(v).size(); i++) {
                int y = graph.get(v).get(i);
                if (!visited[y]) {
                    q.offer(y);
                    visited[y] = true;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        numOfEdges = Integer.parseInt(st.nextToken());
        numOfVertexes = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());
        visited = new boolean[numOfEdges + 1];
        //정점의 개수 만큼 ArrayList를 만들기
        for(int i = 0; i <= numOfEdges; i++) {
            graph.add(new ArrayList<Integer>());
        }
        for(int i = 0; i < numOfVertexes; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        for(int i = 0; i <= numOfEdges; i++) {
            Collections.sort(graph.get(i));
        }
        dfs(startVertex);
        visited = new boolean[numOfEdges + 1];
        System.out.println();
        bfs(startVertex);
        br.close();
    }
}
