package week3;

import java.io.*;

public class Main_BOJ17_3 {
    /*
    1, 00 타일만 사용 가능
    f(n-2) + f(n-1) = f(n)

    n=1 1
    n=2 2
    n=3 3 (f(1) + f(2) = f(3))
    n=4 5 (f(2) + f(3) = f(4))
    ..

    타일 종류가 어떻게 나오는 지는 상관 없으니까,
    1. arr[1], arr[2] 까지는 초기화 해주고
    2. arr[n] 에 arr[n-2] + arr[n-1] 저장
     */
    public static long[] tile;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        tile = new long[1000001];

        tile[1] = 1;
        tile[2] = 2;

        bw.write(String.valueOf(fib(n)));
        bw.flush();
        bw.close();
    }
    public static long fib(int n) {
        //값이 있는지 검사
        for (int i = 3; i < n + 1; i++) {
            tile[i] = (tile[i - 2] + tile[i - 1]) % 15746;
        }
        return tile[n];
    }
}
