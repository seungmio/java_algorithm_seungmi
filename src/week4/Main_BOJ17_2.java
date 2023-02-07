package week4;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ17_2 {
    /*
    dp[1] = 10 -> 1
    dp[2] = 10, 20 -> 2
    dp[3] = 10
    dp[4] = 10, 20, 30
    dp[5] = 10, 20
    dp[6] = 10, 20, 30, 50
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        int[] dp = new  int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            /*
            dp[i] = 1 초기화 안 했을 때 반례
            4
            5 1 2 3 -> 5 때문에 3 안나오고 2가 나옴
             */
            dp[i] = 1;
            for (int j = 1; j <= i; j++) {
                /*
                n = 6              i           j
                i = 1, j <= 1  arr[1] 10 > arr[1] 10 -> dp[1] 1
                i = 2, j <= 2  arr[2] 20 > arr[1] 10 -> dp[2] = dp[1] + 1 = 2
                               arr[2] 20 > arr[2] 20
                i = 4, j <= 4  arr[4] 30 > arr[1] 10 -> da[4] = dp[1] + 1 = 2
                               arr[4] 30 > arr[2] 20 -> dp[4] = dp[2] + 1 = 3
                               ..

                 */
                if (arr[j] < arr[i] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
