import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    private static class Node {
        char root;
        char left;
        char right;
        
        Node(char root, char left, char right) {
            this.root = root;
            this.left = left;
            this.right = right;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        
        Node[] nodes = new Node[n];
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            
            char root = st.nextToken().charAt(0);
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);
            
            nodes[root - 'A'] = new Node(root, left, right);
        }
        
        preOrder(nodes, 'A');
        
        System.out.println();
        
        inOrder(nodes, 'A');
        
        System.out.println();
        
        postOrder(nodes, 'A');
        
        br.close();
    }
    
    private static void preOrder(Node[] nodes, char ch) {
        if (ch == '.') {
            return;
        }
        
        System.out.print(ch);
        
        preOrder(nodes, nodes[ch - 'A'].left);
        
        preOrder(nodes, nodes[ch - 'A'].right);
    }
    
    private static void inOrder(Node[] nodes, char ch) {
        if (ch == '.') {
            return;
        }
        
        inOrder(nodes, nodes[ch - 'A'].left);
        
        System.out.print(ch);
        
        inOrder(nodes, nodes[ch - 'A'].right);
    }
    
     private static void postOrder(Node[] nodes, char ch) {
        if (ch == '.') {
            return;
        }
        
        postOrder(nodes, nodes[ch - 'A'].left);
        
        postOrder(nodes, nodes[ch - 'A'].right);
        
        System.out.print(ch);
    }
}
