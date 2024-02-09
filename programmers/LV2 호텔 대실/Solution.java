import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    private static class Book {
        int start;
        int end;
        
        Book(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    
    private static Book[] arr;
    
    public int solution(String[][] book_time) {
        int length = book_time.length;
        
        arr = new Book[length];
        
        for(int i = 0; i < length; i++) {
            //시작, 종료 시각
            int start = Integer.parseInt(book_time[i][0].replace(":", ""));
            int end = Integer.parseInt(book_time[i][1].replace(":", ""));
            
            end += 10;
            
            //60분이 넘어갔을때 처리
            if(end % 100 >= 60) {
                end += 40;
            }
            
            arr[i] = new Book(start, end);
        }
        
        //시작 시간 오름 차순, 종료 시각 오름 차순
        Arrays.sort(arr, (b1, b2) -> {
            if(b1.start == b2.start)  {
                return b1.end - b2.end;
            }
            return b1.start - b2.start;
        });
        
        //종료 시간이 제일 빠른 방을 기록하기 위해 우선순위 큐 사용
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(Book b : arr) {
            //큐가 비어 있다면 넣는다.
            if(pq.isEmpty()) {
                pq.add(b.end);
                continue;
            } 
            
            int endTime = pq.peek();
            
            if(endTime <= b.start) {
                pq.remove();
                pq.add(b.end);
            } else {
                pq.add(b.end);
            }
        
        }
        
        return pq.size();
    }
}
