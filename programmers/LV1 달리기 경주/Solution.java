import java.util.HashMap;
import java.util.Map;
class Solution {
    public String[] solution(String[] players, String[] callings) {
        Map<Integer, String> rankToPlayer = new HashMap<>();
        Map<String, Integer> playerToRank = new HashMap<>();
        for(int i = 0; i < players.length; i++) {
            rankToPlayer.put(i, players[i]);
            playerToRank.put(players[i], i);
        }
        for(String callingPlayer: callings) {
            int rank = playerToRank.get(callingPlayer);
            String frontPlayer = rankToPlayer.get(rank - 1);

            //등수 갱신
            rankToPlayer.put(rank - 1, callingPlayer);
            rankToPlayer.put(rank, frontPlayer);

            //선수 순서 갱신
            playerToRank.put(callingPlayer, rank - 1);
            playerToRank.put(frontPlayer, rank);
        }
        String[] answer = new String[players.length];
        for(int i = 0; i < players.length; i++) {
            answer[i] = rankToPlayer.get(i);
        }
        return answer;
    }
}
