import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

class Main {
    private static class Student {
        int korean;
        int english;
        int math;
        String name;
        Student(String name, int korean, int english, int math) {
            this.korean = korean;
            this.english = english;
            this.math = math;
            this.name = name;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //N 입력
        int N = Integer.parseInt(br.readLine());

        //학생 배열 선언
        Student[] arr = new Student[N];

        //학생 정보 입력
        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            String name = st.nextToken();
            int korean = Integer.parseInt(st.nextToken());
            int english = Integer.parseInt(st.nextToken());
            int math = Integer.parseInt(st.nextToken());
            arr[i] = new Student(name, korean, english, math);
        }

        //정렬
        Arrays.sort(arr, (s1, s2) -> {
            if(s1.korean == s2.korean) {
                if(s1.english == s2.english) {
                    if(s1.math == s2.math) {
                        //모든 점수가 같을때 사전순으로 증가
                        return s1.name.compareTo(s2.name);
                    }
                    //국어 영어 점수가 같다면 수학 점수 감소하는 형태
                    return s2.math - s1.math;
                }
                //국어 점수가 같으면 영어 점수가 증가하는 형태
                return s1.english - s2.english;
            }
            //국어 점수가 감소하는 형태
            return s2.korean - s1.korean;
        });

        //출력
        StringBuilder sb = new StringBuilder();

        for(Student s : arr) {
            sb.append(s.name).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
