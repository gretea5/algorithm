import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static int N, M;
    public static boolean[] visited;
    public static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    public static int answer;
    public static void bfs(int start, int target) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;
        while(true) {
            int[] cur = q.poll();
            int curPos = cur[0];
            int rollCnt = cur[1];
            if (curPos == target) {
                answer = rollCnt;
                break;
            }
            visited[curPos] = true;
            for(int i = 1; i <= 6; i++) {
                int movePos = curPos + i;
                if (movePos < 0 || movePos > 100) {
                    continue;
                }
                if(!visited[movePos]) {
                    if(list.get(movePos).size() == 0) {
                        q.offer(new int[]{movePos, rollCnt + 1});
                    }
                    else {
                        for(int j = 0; j < list.get(movePos).size(); j++) {
                            int y = list.get(movePos).get(j);
                            q.offer(new int[]{y, rollCnt + 1});
                        }
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[101];
        for(int i = 0; i < 101; i++) {
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
        }
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.get(start).add(end);
        }
        bfs(1, 100);
        System.out.print(answer);
        br.close();
    }
}
