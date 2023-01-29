package week3;

import java.io.*;

public class Main_BOJ17_4 {
    public static long[] arr = new long[101];   //long 타입 안해주니까 오류 남
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr[1] = 1L;
        arr[2] = 1L;
        arr[3] = 1L;

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(fibo(n) + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
    public static long fibo(int n) {
        for (int i = 4; i < n + 1; i++) {
            arr[i] = arr[i - 3] + arr[i - 2];
        }
        return arr[n];
    }
}
