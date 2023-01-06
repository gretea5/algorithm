public class Main {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 2; i <= 100; i++) {
           for(int k = 2; k <= 100; k++) {
                for(int j = k + 1; j <= 100; j++) {
                    for(int h = j + 1; h <= 100; h++) {
                        if(mulTriple(i) == mulTriple(k) + mulTriple(j) + mulTriple(h)) {
                            sb.append("Cube = " + i + ", Triple = (" + k + "," + j + "," + h + ")")
                                    .append("\n");
                        }
                    }
                }
           }
        }
        System.out.print(sb);
    }
    public static int mulTriple(int n ) { return n * n * n;}
}
