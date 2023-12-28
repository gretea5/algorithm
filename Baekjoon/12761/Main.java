import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    static class Point {
        int pos;
        int cnt;
        Point(int pos, int cnt) {
            this.pos = pos;
            this.cnt = cnt;
        }
    }
    public static int A, B, N, M;
    public static boolean[] visited = new boolean[100001];
    public static int bfs(int start, int target) {
        Queue<Point> q = new LinkedList<>();
        q.offer(new Point(start, 0));
        visited[start] = true;
        while(!q.isEmpty()) {
            Point cur = q.poll();
            int curPos = cur.pos;
            int cnt = cur.cnt;
            if(curPos == target) {
                return cnt;
            }
            int movePos = curPos + 1;
            if(0 <= movePos && movePos <= 100000 && !visited[movePos]) {
                q.offer(new Point(movePos, cnt + 1));
                visited[movePos] = true;
            }
            movePos = curPos - 1;
            if(0 <= movePos && movePos <= 100000 && !visited[movePos]) {
                q.offer(new Point(movePos, cnt + 1));
                visited[movePos] = true;
            }
            movePos = curPos + A;
            if(0 <= movePos && movePos <= 100000 && !visited[movePos]) {
                q.offer(new Point(movePos, cnt + 1));
                visited[movePos] = true;
            }
            movePos = curPos - A;
            if(0 <= movePos && movePos <= 100000 && !visited[movePos]) {
                q.offer(new Point(movePos, cnt + 1));
                visited[movePos] = true;
            }
            movePos = curPos + B;
            if(0 <= movePos && movePos <= 100000 && !visited[movePos]) {
                q.offer(new Point(movePos, cnt + 1));
                visited[movePos] = true;
            }
            movePos = curPos - B;
            if(0 <= movePos && movePos <= 100000 && !visited[movePos]) {
                q.offer(new Point(movePos, cnt + 1));
                visited[movePos] = true;
            }
            movePos = curPos * A;
            if(0 <= movePos && movePos <= 100000 && !visited[movePos]) {
                q.offer(new Point(movePos, cnt + 1));
                visited[movePos] = true;
            }
            movePos = curPos * B;
            if(0 <= movePos && movePos <= 100000 && !visited[movePos]) {
                q.offer(new Point(movePos, cnt + 1));
                visited[movePos] = true;
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        System.out.print(bfs(N, M));
        br.close();
    }
}
