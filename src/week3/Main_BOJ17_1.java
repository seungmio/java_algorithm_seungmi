package week3;

import java.io.*;

public class Main_BOJ17_1 {
    /*
    [ DP ]
    동일한 계산을 반복해야 할 때 이전에 계산한 값을 메모리에 저장해서 동일한 계산의 반복 수행을 제거

     */
    public static int n;
    public static int cnt1;
    public static int cnt2;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        fib(n);
        fibonacci(n);

        sb.append(cnt1 + " " + cnt2);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    public static int fib(int num) {
        /*
        재귀호출 의사 코드
        ex) f(5) = f(4) + f(3)
        =  fib(3) + fib(2) + fib(3)
        = fib(2) + fib(1) + fib(2) + fib(2) + fib(1)
        = 3*fib(2) + 2*fib(1)
         */
        if (num == 1 || num == 2) {
            cnt1++;
            return 1;
        } else {
            return fib(num - 1) + fib(num - 2);
        }
    }
    public static int fibonacci(int num) {
        /*
        ex )
        dp[3] = dp[2] + dp[1] = 1 + 1 = 2
        dp[4] = dp[3] + dp[2] = 2 + 1 = 3
        dp[5] = dp[4] + dp[3] = 3 + 2 = 5
         */
        int[] f = new int[n+1];
        f[1] = 1;
        f[2] = 1;

        for (int i = 3; i <= n; i++) {
            cnt2++;
            f[i] = f[i - 1] + f[i - 2];
        }

        return f[n];
    }
}
