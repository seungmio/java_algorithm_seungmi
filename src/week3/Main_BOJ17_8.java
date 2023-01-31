package week3;

import java.io.*;

public class Main_BOJ17_8 {
    /*
    계단이 n개 일 때,
    1 - 2 - 3 (연속된 3개의 수 X)
    1 - 4 (+3이 된 수 X)
    1 - 2 - 4 - 5 - ? (마지막이 n을 넘어가는 수 X)

    (n-3) (n-2) (n-1) n
    (n-3) -> (n-1) -> n
    (n-1) -> (n-3) -> n
    (n-2) -> n
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] floor = new int[n + 1];
        int[] MAX = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            floor[i] = Integer.parseInt(br.readLine());
        }


        MAX[1] = floor[1];

        if (n >= 2) {
            MAX[2] = floor[1] + floor[2];
            for (int i = 3; i <= n; i++) {
                MAX[i] += Math.max(MAX[i - 3] + floor[i - 1], MAX[i - 2]) + floor[i];
            }
        }

        bw.write(String.valueOf(MAX[n]));
        bw.flush();
        bw.close();
    }
}
