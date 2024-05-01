import java.util.Scanner;

public class Solution {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);

        for(int test = 1; test <= 10; test++) {
            int t = sc.nextInt();

            sc.nextLine();

            int a = sc.nextInt();
            int b = sc.nextInt();

            sc.nextLine();

            System.out.print("#" + t + " ");
            System.out.println(recursion(a, b));
        }

        sc.close();
    }

    private static int recursion(int a, int b) {
        if (b == 1) {
            return a;
        }

        return a * recursion(a, b - 1);
    }
}
