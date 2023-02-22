package week5;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ25_2 {
    /*
    arr    1 5 2 1 4 3 4 5 2 1
   오름차순 1 2 2 1 3 3 4 5 2 1
   내림차순 1 5 2 1 4 3 3 3 2 1
   바이토닉 1 6 3 1 6 5 6 7 3 1 (오름 + 내림 - 1)

    [점화식]
    n == 1 일 때, 1
    n == 2 일 때, 2
    n >= 3 일 때,
    dp[i] = up[i] + down[i] - 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    //수열의 크기
        int[] arr = new int[n + 1];
        int[] up = new int[n + 1];
        int[] down = new int[n + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //오름차순
        for (int i = 0; i < n; i++) {
            up[i] = 1;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j] && up[i] < up[j] + 1) {
                    up[i] = up[j] + 1;
                }
            }
        }

        //내림차순
        for (int i = n - 1; i >= 0; i--) {
            down[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (arr[i] > arr[j] && down[i] < down[j] + 1) {
                    down[i] = down[j] + 1;
                }
            }
        }

        //바이토닉
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < up[i] + down[i] - 1) {
                max = up[i] + down[i] - 1;
            }
        }

        bw.write(String.valueOf(max));
        bw.flush();
        bw.close();
    }
}
