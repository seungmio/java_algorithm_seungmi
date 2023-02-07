package week4;

import java.io.*;

public class Main_BOJ17_3 {
    /*
    1~9
    1. 길이가 1
        1 / 2 / 3 ... / 9
    2. 길이가 2
        1 2 / 1 0 / 2 3 / 2 1 ...

    * 0 다음에는 1만 올 수 있고, 9 다음에는 8만 올 수 있다. 그 외에는 k-1 or k+1

    [3자리 경우]
    1
    0 1 2 3 4 5 6 7 8 9
    0 1 1 1 1 1 1 1 1 1 => 9

    2
    0 1 2 3 4 5 6 7 8 9
    0 1 2 2 2 2 2 2 2 2 => 17

    3
    0 1 2 3 4 5 6 7 8 9
    1 2 3 4 4 4 4 4 4 2 => 32


    1 -> 0
      -> 2
    2 -> 1
      -> 3
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        //[자릿수][자리에 올 수 있는 수]
        long[][] arr = new long[n + 1][10];

        for (int i = 1; i <= 9; i++) {
            arr[1][i] = 1;  //첫번째 자리에는 1~9까지 올 수 있으니까
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                if (j == 0) {
                    arr[i][j] = arr[i - 1][1] % 1000000000;
                } else if (j == 9) {
                    arr[i][j] = arr[i - 1][8] % 1000000000;
                } else {
                    arr[i][j] = (arr[i - 1][j - 1] + arr[i - 1][j + 1]) % 1000000000;
                }
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += arr[n][i];
        }

        bw.write(String.valueOf(result % 1000000000));
        bw.flush();
        bw.close();
    }
}
