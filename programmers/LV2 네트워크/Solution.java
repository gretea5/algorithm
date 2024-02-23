import java.util.HashSet;

class Solution {
    private static int[] parent;
    
    public int solution(int n, int[][] computers) {
        parent = new int[n];
        
        for(int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
        
        for(int i = 0; i < computers.length; i++) {
            for(int j = 0; j < computers[i].length; j++) {
                if(computers[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        
        HashSet<Integer> set = new HashSet<>();
        
        for(int i = 0; i < parent.length; i++) {
            set.add(find(i));
        }
        
        return set.size();
    }
    
    private static void union(int a, int b) {
        int x = find(a);
        int y = find(b);
        
        parent[x] = y;
    }
    
    private static int find(int a) {
        if(parent[a] == a) return a;
        
        parent[a] = find(parent[a]);
        
        return parent[a];
    }
}
