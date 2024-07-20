import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    private static ArrayList<Integer>[] graph;
    
    private static boolean[] visited;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        graph = new ArrayList[n];
        
        for(int i = 0; i < n; i++)  {
            graph[i] = new ArrayList<>();
        }
        
        int root = -1;
        
        //현재 노드의 부모 정보를 담을 배열
        int[] arr = new int[n];
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        for(int i = 0; i < n; i++) {
            int parent = Integer.parseInt(st.nextToken());
            
            //루트일때,
            if (parent == -1) {
                root = i;
                continue;
            }
            
            graph[parent].add(i);

            arr[i] = parent;
        }
        
        int removeNode = Integer.parseInt(br.readLine());
        
        //삭제노드와 루드노드가 동일할 경우
        if (removeNode == root) {
            System.out.print(0);
            return;
        }
        
        //삭제 노드의 부모 정보를 가져온다.
        int removeParent = arr[removeNode];
        
        //삭제 노드의 부모와 삭제 노드의 연결을 끊어준다.
        for(int i = 0; i < graph[removeParent].size(); i++) {
            if (graph[removeParent].get(i) == removeNode) {
                graph[removeParent].remove(i);
                break;
            }
        }
        
        //방문체크
        visited = new boolean[n];
        
        dfs(removeNode);
        
        int answer = 0;
        
        for(int i = 0; i < n; i++) {
            //방문이 되지 않았으면서 자식이 없다면 => 리프노드
            if (!visited[i] && graph[i].size() == 0) {
                answer += 1;
            }
        }
        
        System.out.print(answer);
        
        br.close();
    }
    
    private static void dfs(int start) {
        visited[start] = true;
        
        for(int next : graph[start]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
