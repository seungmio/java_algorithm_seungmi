package week6;

import java.io.*;
import java.util.StringTokenizer;

public class Main_22_1 {
    /*
    [행렬 곱셈]
    function F(x):
        if F(x)가 간단 then:
        return F(x)를 계산한 값
    else:
        x 를 x1, x2로 분할
        F(x1)과 F(x2)를 호출
        return F(x1), F(x2)로 F(x)를 구한 값
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //A
        int m = Integer.parseInt(st.nextToken());   // m 3
        int k = Integer.parseInt(st.nextToken());   // k 2

        int[][] A = new int[m][k];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                A[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //B
        st = new StringTokenizer(br.readLine());
        st.nextToken(); //어차피 같은 수라 변수에 대입할 필요 없다.
        int n = Integer.parseInt(st.nextToken());   //n 3

        int[][] B = new int[k][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                B[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int result = 0; //행렬곱 결과를 담을 변수
                for (int l = 0; l < k; l++) {
                    result += A[i][l] * B[l][j];
                }
                sb.append(result + " ");
            }
            sb.append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
