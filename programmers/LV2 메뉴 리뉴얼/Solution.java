import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Collections;

class Solution {
    private static ArrayList<String> list;
    private static HashMap<String, Integer> map;
    private static int max;
    
    public String[] solution(String[] orders, int[] course) {
        
        list = new ArrayList<>();
        
        for(int c : course) {
            
            map = new HashMap<>();
            
            max = Integer.MIN_VALUE;
            
            //단품 메뉴들의 조합의 개수를 구한다.
            for(String order : orders) {
                char[] arr = order.toCharArray();
                //정렬한다 => 그래야 순서가 보장된다. #testcase3
                Arrays.sort(arr);
                //정렬한 문자열
                String sortedOrder = new String(arr);
                //단품메뉴의 갯수에 따른 조합을 map에 기록한다.
                dfs(sortedOrder, "", 0, 0, c);
            }
            
            for(String key : map.keySet()) {
                int v = map.get(key);
                //최소 두명의 이상의 손님 가장 많이 주문한 단품메뉴라면 넣는다.
                if(v >= 2 && max == v) {
                    list.add(key);
                }
            }
        }
        //정렬
        Collections.sort(list);
    
        //String 배열로 넘김
        return list.toArray(new String[list.size()]);
    }
    
    private static void dfs(String order, String str, int idx, int depth, int course) {
        //course만큼 메뉴를 구성했을 경우 갯수를 기록한다.
        if(depth == course) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            //최대 갯수 기록
            max = Math.max(max, map.get(str));
            return;
        }
        
        for(int i = idx; i < order.length(); i++) {
            dfs(order, str + order.charAt(i), i + 1, depth + 1, course);
        }
    }
    
}
