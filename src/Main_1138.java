import java.io.*;
import java.util.StringTokenizer;

public class Main_1138 {
    /*
    키가 1인 사람 2
    키가 2인 사람 1
    키가 3인 사람 1
    키가 4인 사람 0

    4
    4 3
    4 2 3
    4 2 1 3
     */
    static int N;
    static int[] people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());


        people = new int[N+1];
        for (int i = 1; i <= N; i++) {  //키
            int left = Integer.parseInt(st.nextToken());    //왼쪽에 나보다 키큰 사람
            for (int j = 1; j <= N; j++) {  //자리
                if (left == 0 && people[j] == 0) {    //왼쪽에 나보다 키큰사람이 없음
                    people[j] = i;  //작은 순서대로 들어오니까 해당 idx가 내자리
                    break;
                } else if (people[j] == 0) {    //왼쪽에 나보다 키큰사람이 left 명 있음
                    left--; //한자리 양보
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(people[i]).append(" ");
        }

        bw.write(String.valueOf(sb));
        bw.close();
    }
}
