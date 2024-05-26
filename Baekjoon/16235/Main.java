import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    private static int n;
    
    private static int[][] board;
    private static int[][] addArr;
    private static ArrayList<Integer>[][] trees;
    
    private static final int[] dx = {1, 1, 1, -1, -1, -1, 0, 0};
    private static final int[] dy = {0, 1, -1, 0, 1, -1, 1, -1};
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        board = new int[n][n];
        addArr = new int[n][n];
        trees = new ArrayList[n][n];
        
        //처음의 양분 상태 저장
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] = 5;
            }
        }
        
        //양분을 추가하는 배열을 저장
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            for(int j = 0; j < n; j++) {
                addArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        //나무 상태 초기화
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                trees[i][j] = new ArrayList<>();
            }
        }
        
        //초기 나무 정보 저장
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            
            trees[x - 1][y - 1].add(age);
        }
        
        while(k > 0) {
            //봄, 여름(양분을 먹고, 죽은 나무 처리)
            eatBoard();
            
            //가을(나무가 번식한다.)
            growTrees();
            
            //겨울
            addIngredient();
            
            k -= 1;
        }
        
        //살아남은 나무의 갯수
        int sum = 0;
        
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                sum += trees[i][j].size();
            }
        }
        
        System.out.print(sum);
        
        br.close();
    }
    
    private static void eatBoard() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                //즉 나무가 있다면, 
                if (trees[i][j].size() > 0) {
                    //나이가 어린 순 부터 양분을 먹어야하니까,
                    Collections.sort(trees[i][j]);
                    
                    //죽기 시작한 나무 인덱스
                    int kIdx = -1;
                    
                    for(int h = 0; h < trees[i][j].size(); h++) {
                        //즉 나무가 양분을 먹을 수 있다면, => 먹는다.
                        if (board[i][j] >= trees[i][j].get(h)) {
                            board[i][j] -= trees[i][j].get(h);
                            
                            //나이를 꺼내서
                            int age = trees[i][j].remove(h);
                            
                            //h인덱스에 1을 더한 값을 다시 넣는다.
                            trees[i][j].add(h, age + 1);
                        }
                        //먹을 수 없다면, 죽기 시작한 나무 인덱스 저장
                        else {
                            kIdx = h;
                            break;
                        }
                    }
                    
                    //죽기 시작한 나무 인덱스가 있다면,
                    if (kIdx != -1) {
                        //양분 추가
                        for(int h = trees[i][j].size() - 1; h >= kIdx; h--) {
                            int age = trees[i][j].remove(h);
                            
                            int add = age / 2;
                            
                            board[i][j] += add;
                        }
                    }
                }
            }
        }
    }
    
    private static void growTrees() {
         for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                for(int age : trees[i][j]) {
                    //5의 배수라면,
                    if (age % 5 == 0 && age >= 5) {
                        //8개의 인접한 곳에 1의 나무를 심는다.
                        for(int h = 0; h < 8; h++) {
                            int mx = i + dx[h];
                            int my = j + dy[h];
                            
                            if (mx < 0 || mx >= n || my < 0 || my >= n) {
                                continue;
                            }
                            
                            trees[mx][my].add(1);
                        }
                    }
                }
            }
         }
    }
    
    private static void addIngredient() {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                board[i][j] += addArr[i][j];
            }
        }
    }
}
