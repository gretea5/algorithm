import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Collections;

public class Main {
    private static class Pos {
        int likeCount; 
        int nearCount;
        int x;
        int y;
        
        Pos(int likeCount, int nearCount, int x, int y) {
            this.likeCount = likeCount;
            this.nearCount = nearCount;
            this.x = x;
            this.y = y;
        }
    }
    
    private static int n;
    
    private static int[][] board;
    private static ArrayList<Integer>[] likeGraph;
    
    private static final int[] dx = {1, -1, 0, 0};
    private static final int[] dy = {0, 0, 1, -1};
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		int studentNumber = n * n;
		
		int[] order = new int[studentNumber];
		
		likeGraph = new ArrayList[studentNumber + 1];
		
		for(int j = 0; j < studentNumber + 1; j++) {
	        likeGraph[j] = new ArrayList<>();
	    }
		
		for(int i = 0; i < studentNumber; i++) {
		    StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		    
		    int student = Integer.parseInt(st.nextToken());
		    
		    order[i] = student;
		    
		    for(int j = 0; j < 4; j++) {
		        int likeNumber = Integer.parseInt(st.nextToken());
		        
		        likeGraph[student].add(likeNumber);
		    }
		}
		
		board = new int[n][n];
		
		for(int i = 0; i < order.length; i++) {
		    ArrayList<Pos> locList = new ArrayList<>();
		    
		    //학생의 정보를 가져왔음
		    int student = order[i];
		    
		    for(int x = 0; x < n; x++) {
    		    for(int y = 0; y < n; y++) {
    		        if (board[x][y] != 0) {
    		            continue;
    		        }
    		        
    		        //좋아하는 학생의 개수
    		        int likeCount = calLikeCount(student, x, y);
    		        
    		        //인접한 빈칸의 개수
    		        int nearCount = calNearCount(student, x, y);
    		        
    		        locList.add(new Pos(likeCount, nearCount, x, y));
    		    }
    		}
    		
    		Collections.sort(locList, (p1, p2) -> {
    		    if (p1.likeCount == p2.likeCount) {
    		        if (p1.nearCount == p2.nearCount) {
    		            if (p1.x == p2.x) {
    		                return p1.y - p2.y;
    		            }
    		            
    		            return p1.x - p2.x;
    		        }
    		        
    		        return p2.nearCount - p1.nearCount;
    		    }
    		    
    		    return p2.likeCount - p1.likeCount;
    		});
    		
    		Pos location = locList.get(0);
    		
    		board[location.x][location.y] = student;
		}
		
		int answer = 0;
		
		for(int i = 0; i < n; i++) {
		    for(int j = 0; j < n; j++) {
		        int value = calLikeCount(board[i][j], i, j);
		        
		        if (value == 0) {
		            answer += 0;
		        }
		        else if (value == 1) {
		            answer += 1;
		        }
		        else if (value == 2) {
		            answer += 10;
		        }
		        else if (value == 3) {
		            answer += 100;
		        }
		        else if (value == 4) {
		            answer += 1000;
		        }
		    }
		}
		
		System.out.print(answer);
		
		br.close(); 
	}
	
	private static int calLikeCount(int student, int x, int y) {
	    int count = 0;
	    
	    for(int i = 0; i < 4; i++) {
	        int mx = x + dx[i];
	        int my = y + dy[i];
	        
	        if (mx < 0 || mx >= n || my < 0 || my >= n) {
	            continue;
	        }
	        
	        if (likeGraph[student].contains(board[mx][my])) {
	            count += 1;
	        }
	    }
	    
	    return count;
	}
	
	private static int calNearCount(int student, int x, int y) {
	    int count = 0;
	    
	    for(int i = 0; i < 4; i++) {
	        int mx = x + dx[i];
	        int my = y + dy[i];
	        
	        if (mx < 0 || mx >= n || my < 0 || my >= n) {
	            continue;
	        }
	        
	        if (board[mx][my] == 0) {
	            count += 1;
	        }
	    }
	    
	    return count;
	}
}
