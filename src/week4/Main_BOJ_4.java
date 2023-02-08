package week4;

import java.io.*;

public class Main_BOJ_4 {
    /*
    dp  6 16 23
    arr 6 10 13 9 8 1


    [숫자 3개를 연속하지 않고 선택하는 방법]
    oox (마지막 포도주를 무조건 선택하지 않아도 되기 때문에) dp[i-1]
    oxo dp[i-2] + arr[i]
    xoo dp[i-3] + arr[i-1] + arr[i]

     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        dp[1] = arr[1];

        if (n >= 2) {
            dp[2] = arr[1] + arr[2];
            for (int i = 3; i <= n; i++) {
                dp[i] += Math.max(dp[i - 1], Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 2] + arr[i]));
            }
        }

        bw.write(String.valueOf(dp[n]));
        bw.flush();
        bw.close();
    }
}
