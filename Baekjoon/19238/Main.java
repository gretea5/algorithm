import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.ArrayDeque;
import java.util.Collections;

public class Main {
    private static class Pos {
        int x;
        int y;
        int dist;

        Pos(int x, int y, int dist) {
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }

    private static class Guest {
        int startX;
        int startY;
        int endX;
        int endY;

        Guest(int startX, int startY, int endX, int endY) {
            this.startX = startX;
            this.startY = startY;
            this.endX = endX;
            this.endY = endY;
        }
    }

    private static int n;

    private static int[][] map;

    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int gas = Integer.parseInt(st.nextToken());

        map = new int[n + 1][n + 1];

        //지도 정보
        for(int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 1; j < n + 1; j++) {
                int v = Integer.parseInt(st.nextToken());
                map[i][j] = v == 1 ? -1 : v;
            }
        }

        st = new StringTokenizer(br.readLine(), " ");

        //현재 택시의 위치
        int taxiX = Integer.parseInt(st.nextToken());
        int taxiY = Integer.parseInt(st.nextToken());

        //손님의 출발, 도착 지점
        Guest[] guests = new Guest[m];

        //손님의 위치를 기록
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());

            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());

            guests[i] = new Guest(startX, startY, endX, endY);
        }

        //손님의 시작 위치를 기록
        for(int i = 0; i < m; i++) {
            int startX = guests[i].startX;
            int startY = guests[i].startY;

            //1부터 기록 되게 함
            map[startX][startY] = i + 1;
        }

        for(int i = 0; i < m; i++) {
            //가까운 손님의 위치를 찾는다.
            Pos guestPos = findGuest(taxiX, taxiY);

            //손님을 찾지 못했어,
            if (guestPos == null) {
                System.out.print(-1);
                return;
            }

            //연료를 소진
            gas -= guestPos.dist;

            //연료를 소진해서 손님에게 도달할 수 없는 경우,
            if (gas <= 0) {
                System.out.print(-1);
                return;
            }

            //손님의 위치와 택시의 위치로 이동
            taxiX = guestPos.x;
            taxiY = guestPos.y;

            //손님의 정보가 기록되어있는 정보
            int idx = map[taxiX][taxiY] - 1;

            //손님의 목적지 정보로 이동
            int endX = guests[idx].endX;
            int endY = guests[idx].endY;

            //손님을 태웠기 때문에, 빈칸이 되어버린다.
            map[taxiX][taxiY] = 0;

            //목적지 까지의 이동거리 계산
            int cost = gotoDestination(taxiX, taxiY, endX, endY);

            //연료 소진
            gas -= cost;

            //소모되거나, 목적지까지 이동할 수 없다면,
            if (gas < 0 || cost == -1) {
                System.out.print(-1);
                return;
            }

            //연료 양의 두 배가 충전
            gas += (cost * 2);

            //택시의 위치 갱신
            taxiX = endX;
            taxiY = endY;
        }

        System.out.print(gas);

        br.close();
    }

    //목적지로 이동하는 로직
    private static int gotoDestination(int startX, int startY, int endX, int endY) {
        boolean[][] visited = new boolean[n + 1][n + 1];

        ArrayDeque<Pos> queue = new ArrayDeque<>();

        queue.addLast(new Pos(startX, startY, 0));
        visited[startX][startY] = true;

        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();

            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;

            if (x == endX && y == endY) {
                return dist;
            }

            for(int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx < 1 || mx > n || my < 1 || my > n) {
                    continue;
                }

                if (!visited[mx][my] && map[x][y] >= 0) {
                    queue.addLast(new Pos(mx, my, dist + 1));
                    visited[mx][my] = true;
                }
            }
        }

        return -1;
    }

    //손님을 찾는다.
    private static Pos findGuest(int taxiX, int taxiY) {
        boolean[][] visited = new boolean[n + 1][n + 1];

        ArrayDeque<Pos> queue = new ArrayDeque<>();

        //손님들의 정보를 담을 arrayList
        ArrayList<Pos> guestList = new ArrayList<>();

        queue.addLast(new Pos(taxiX, taxiY, 0));
        visited[taxiX][taxiY] = true;


        while(!queue.isEmpty()) {
            Pos cur = queue.removeFirst();

            int x = cur.x;
            int y = cur.y;
            int dist = cur.dist;

            if (map[x][y] > 0) {
                //손님의 정보를 담는다.
                guestList.add(cur);
            }

            for(int i = 0; i < 4; i++) {
                int mx = x + dx[i];
                int my = y + dy[i];

                if (mx < 1 || mx > n || my < 1 || my > n) {
                    continue;
                }

                if (!visited[mx][my] && map[x][y] >= 0) {
                    queue.addLast(new Pos(mx, my, dist + 1));
                    visited[mx][my] = true;
                }
            }
        }

        //손님이 있을 경우,
        if (!guestList.isEmpty()) {
            //정렬
            Collections.sort(guestList, (p1, p2) -> {
                if (p1.dist == p2.dist) {
                    if (p1.x == p2.x) {
                        return p1.y - p2.y;
                    }

                    return p1.x - p2.x;
                }

                return p1.dist - p2.dist;
            });

            return guestList.get(0);
        }

        //손님이 없을 경우, null
        return null;
    }
}
