import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Collections;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static int numOfEdge;
    public static int numOfVertex;
    public static int startVertex;
    public static boolean visited[];
    public static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    public static int count = 1;
    public static int arr[];
    public static void dfs(int x) {
        visited[x] = true;
        arr[x] = count++;
        for(int i = 0; i < graph.get(x).size(); i++) {
            int y = graph.get(x).get(i);
            if (!visited[y]) dfs(y);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        numOfEdge = Integer.parseInt(st.nextToken());
        numOfVertex = Integer.parseInt(st.nextToken());
        startVertex = Integer.parseInt(st.nextToken());
        arr = new int[numOfEdge + 1];
        visited = new boolean[numOfEdge + 1];
        Arrays.fill(arr, 0);
        Arrays.fill(visited, false);
        for(int i = 0; i < numOfEdge + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for(int i = 0; i < numOfVertex; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            graph.get(v2).add(v1);
        }
        for(int i = 0; i < numOfEdge + 1; i++) {
            Collections.sort(graph.get(i));
        }
        dfs(startVertex);
        for(int i = 1; i < numOfEdge + 1; i++) {
            System.out.println(arr[i]);
        }
        br.close();
    }
}
