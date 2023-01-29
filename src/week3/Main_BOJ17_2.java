package week3;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ17_2 {
    /*
    동적 계획법의 특징: 재귀+메모이제이션
    -> 처음 방문하는 재귀라면 계산을 통해 얻은 값을 메모리에 저장(기록)하고,
    이 후 재방문을 할 경우 다시 계산하는 것이 아닌 저장 된 값을 사용하라는 것이다.
     */

    //20이 넘어가면 return 해주기 때문에 배열 사이즈는 21로 맞춰준다.
    public static int[][][] abc= new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            sb.append("w(" + a + ", " + b + ", " + c + ")" + " = " + w(a, b, c) + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
    public static int w(int a, int b, int c) {
        //처음 if 문 검사할 때 a, b, c 에 음수나 20보다 큰 수가 들어올 수도 있어서 오류 발생
        if ((a >= 0 && a <= 20) && (b >= 0 && b <= 20) && (c >= 0 && c <= 20)) {
            if (abc[a][b][c] != 0) {    //여기서 ArrayIndexOutOfBoundsException 오류 발생
            /*
            abc[a][b][c] 가 0 이면 아직 저장되어 있지 않다는 뜻이고,
            0이 아니면 이미 계산 되어서 값이 저장되어 있다는 뜻이다.
             */
                return abc[a][b][c];
            }
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return w(20, 20, 20);
        }

        if (a < b && b < c) {
            return abc[a][b][c] = w(a, b, c -1) + w(a, b - 1, c -1) - w(a, b - 1, c);
        }

        else {
            return abc[a][b][c] = w(a-1, b, c) + w(a-1, b-1, c) + w(a-1, b, c-1) - w(a-1, b-1, c-1);
        }
    }
}
