import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    private static class Page {
        int number;
        int count;

        Page(int number, int count) {
            this.number = number;
            this.count = count;
        }
    }

    private static int curPageNumber;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        ArrayDeque<Page> frontDeque = new ArrayDeque<>();
        ArrayDeque<Page> backDeque = new ArrayDeque<>();

        //현재 페이지 번호 초기화
        curPageNumber = -1;

        for(int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            //작업
            String command = st.nextToken();

            //뒤로가기를 실행
            if (command.equals("B")) {
                goBack(frontDeque, backDeque);
            }
            //앞으로 가기
            else if (command.equals("F")) {
                goFront(frontDeque, backDeque);
            }
            //접속하기
            else if (command.equals("A")) {
                int accessNumber = Integer.parseInt(st.nextToken());

                access(frontDeque, backDeque, accessNumber);
            }
            //압축하기
            else if (command.equals("C")) {
                compress(backDeque);
            }
        }

        StringBuilder sb = new StringBuilder();

        sb.append(curPageNumber).append("\n");

        if (backDeque.isEmpty()) {
            sb.append(-1);
        }
        else {
            while (!backDeque.isEmpty()) {
                Page p = backDeque.removeLast();

                for(int i = 0; i < p.count; i++) {
                    sb.append(p.number).append(" ");
                }
            }
        }

        sb.append("\n");

        if (frontDeque.isEmpty()) {
            sb.append(-1);
        }
        else {
            while (!frontDeque.isEmpty()) {
                Page p = frontDeque.removeLast();

                for(int i = 0; i < p.count; i++) {
                    sb.append(p.number).append(" ");
                }
            }
        }

        System.out.print(sb);

        br.close();
    }

    private static void goBack(ArrayDeque<Page> frontDeque, ArrayDeque<Page> backDeque) {
        //뒤로 가기 공간에 저장 되지 않았을 경우,
        if (!backDeque.isEmpty()) {
            //현재 보고 있던 웹 페이지를 앞으로 가기 공간에 저장한다.
            frontDeque.addLast(new Page(curPageNumber, 1));

            //뒤로 가기 공간에서 방문한지 가장 최근의 페이지 접속, 그 페이지는 뒤로가기 공간에서 삭제
            Page backPage = backDeque.removeLast();

            int backPageNumber = backPage.number;
            int backPageCount = backPage.count;

            //현재 페이지 갱신
            curPageNumber = backPageNumber;

            //뒤로 가기 페이지에 데이터가 남아 있는 경우,
            if (backPageCount - 1 > 0) {
                backPageCount -= 1;

                backDeque.addLast(new Page(backPageNumber, backPageCount));
            }

            //남아 있지 않았다면 그냥 제거
        }
    }

    private static void goFront(ArrayDeque<Page> frontDeque, ArrayDeque<Page> backDeque) {
        if (!frontDeque.isEmpty()) {
            //현재 보고 있는 웹 페이지를 뒤로 가기 공간에 저장해야하는데,,
            if (backDeque.isEmpty()) {
                backDeque.addLast(new Page(curPageNumber, 1));
            }
            else {
                Page backPage = backDeque.peekLast();

                //현재 보고 있는 페이지와 뒤로 가기 공간의 최근 페이지와 번호가 동일하다면,
                if (backPage.number == curPageNumber) {
                    backPage = backDeque.removeLast();

                    int backPageNumber = backPage.number;
                    int backPageCount = backPage.count;

                    backDeque.addLast(new Page(curPageNumber, backPageCount + 1));
                }
                //현재 보고 있는 페이지와 뒤로 가기 공간의 최근 페이지 번호가 다르면
                else {
                    backDeque.addLast(new Page(curPageNumber, 1));
                }
            }

            //앞으로 가기 공간에서 방문한지 가장 최근의 페이지에 접속한다.
            curPageNumber = frontDeque.removeLast().number;
        }
    }

    private static void access(ArrayDeque<Page> frontDeque, ArrayDeque<Page> backDeque, int accessNumber) {
        frontDeque.clear();

        if (curPageNumber != -1) {
            if (!backDeque.isEmpty()) {
                //현재 페이지를 뒤로 가기 공간에 추가
                Page peekBackPage = backDeque.peekLast();

                if (peekBackPage.number == curPageNumber) {
                    Page backPage = backDeque.removeLast();

                    int backPageNumber = backPage.number;
                    int backPageCount = backPage.count;

                    backDeque.addLast(new Page(curPageNumber, backPageCount + 1));
                }
                else {
                    backDeque.addLast(new Page(curPageNumber, 1));
                }
            }
            else {
                backDeque.addLast(new Page(curPageNumber, 1));
            }
        }

        curPageNumber = accessNumber;
    }

    private static void compress(ArrayDeque<Page> backDeque) {
        int size = backDeque.size();

        while (size > 0) {
            Page page = backDeque.removeLast();

            backDeque.addFirst(new Page(page.number, 1));

            size -= 1;
        }
    }
}

