import java.util.Queue;
import java.util.LinkedList;

class Solution {
    public static int CACHE_HIT = 1;
    public static int CACHE_MISS = 5;
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        Queue<String> q = new LinkedList<>();
        for(String city : cities) {     //10_0000
            city = city.toUpperCase();
            if(!q.contains(city)) {      //즉 큐에 포함되어 있지 않은 경우,      //30
                answer += CACHE_MISS;
                q.offer(city);
                if(q.size() > cacheSize) {
                    q.poll();
                }
            }
            else {  //큐에 포함되어 있는 경우,
                answer += CACHE_HIT;
                q.remove(city);
                q.offer(city);
            }
        }
        return answer;
    }
}
