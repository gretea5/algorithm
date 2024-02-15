import java.util.ArrayList;

class Solution {
    private static ArrayList<ArrayList<Integer>> graph;
    private static boolean[] visited;
    private static int cnt;
    private static int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        //제외 시킬 전선에 대한 인덱스
        for(int tIdx = 0; tIdx < wires.length; tIdx++) {
            
            //초기화 부분
            graph = new ArrayList<>();
            visited = new boolean[n + 1];
            
            for(int i = 0; i < n + 1; i++) {
                graph.add(new ArrayList<>());
            }
            
            for(int i = 0; i < wires.length; i++) {
                //제외 시킬 전선 빼고 나머지 전선의 정보를 넣어주기
                if(tIdx != i) {
                    int v1 = wires[i][0];
                    int v2 = wires[i][1];
                    
                    graph.get(v1).add(v2);
                    graph.get(v2).add(v1);
                }
            }
            
            //송전탑의 개수
            cnt = 0;
            
            dfs(1);
            
            //트리이므로, 나머지는 n - 송전탑의 개수이므로,
            answer = Math.min(answer, Math.abs(cnt - (n - cnt)));
        }
        
        //차이의 최솟값을 구함
        return answer;
    }
    
    private static void dfs(int v) {
        //방문처리
        visited[v] = true;
        //송전탑의 갯수를 증가
        cnt += 1;
        
        for(int i = 0; i < graph.get(v).size(); i++) {
            //인접 송전탑이 있다면,
            if(!visited[graph.get(v).get(i)]) {
                dfs(graph.get(v).get(i));
            }
        }
    }
    
}
