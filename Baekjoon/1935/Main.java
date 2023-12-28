import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String expression = br.readLine();
        double[] arr = new double[N];
        for(int i = 0; i < N; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }
        Stack<Double> stack = new Stack<>();
        for(int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if('A' <= c && c <= 'Z') {
                stack.push(arr[(int) c - 'A']);
            } else {
                double u = stack.pop();
                double v = stack.pop();
                if (c == '*') {
                    stack.push(v * u);
                }
                else if (c == '+') {
                    stack.push(v + u);
                }
                else if (c == '-') {
                    stack.push(v - u);
                }
                else if (c == '/') {
                    stack.push(v / u);
                }
            }
        }
        double answer = stack.pop();
        System.out.printf("%.2f", answer);
        br.close();
    }
}
