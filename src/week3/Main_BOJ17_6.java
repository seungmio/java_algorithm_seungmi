package week3;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ17_6 {
    /*
    1. 빨간색/초록색/파란색일 때를 나눠서

    ex) 빨강을 칠한다면 빨강+초록 or 빨강+파랑 비용 중 최솟값을 택함.

    2. 배열에 저장
    3. 처음 색깔이 빨간색/초록색/파란색일 때 중 최솟값을 택함.
     */
    public static int[][] rgb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());    //집의 수
        rgb = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            rgb[i][0] = Integer.parseInt(st.nextToken());   //red
            rgb[i][1] = Integer.parseInt(st.nextToken());   //green
            rgb[i][2] = Integer.parseInt(st.nextToken());   //blue
        }

        for (int i = 1; i < n; i++) {
            //Math 에 있는 min, max 함수 구글링
            //red
            rgb[i][0] += Math.min(rgb[i - 1][1], rgb[i - 1][2]);
            //green
            rgb[i][1] += Math.min(rgb[i - 1][0], rgb[i - 1][2]);
            //blue
            rgb[i][2] += Math.min(rgb[i - 1][0], rgb[i - 1][1]);
        }

        bw.write(String.valueOf(Math.min(Math.min(rgb[n - 1][0], rgb[n - 1][1]), rgb[n - 1][2])));
        bw.flush();
        bw.close();
    }
}
