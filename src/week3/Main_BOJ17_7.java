package week3;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ17_7 {
    /*
    위에서부터 아래로 더하면 X (경우의 수가 너무 많아진다)
    아래에서부터 위로 더해 누적해가는 방식으로
    arr[층][값 idx]
    arr[4][1] += max(arr[5][1], arr[5][2])
    arr[4][2] += max(arr[5][2], arr[5][3])
    ...
    arr[4][4] += max(arr[5][4] ,arr[5][5])
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] tri = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= i; j++) {
                tri[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n; i >= 1; i--) {
            for (int j = 1; j <= i - 1; j++) {
                tri[i - 1][j] += Math.max(tri[i][j], tri[i][j + 1]);
            }
        }

        bw.write(String.valueOf(tri[1][1]));
        bw.flush();
        bw.close();
    }
}
