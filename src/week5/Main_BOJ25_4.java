package week5;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_BOJ25_4 {
    /*
    전봇대 2차원 배열 사용 -> pole[n][2]
    dp 에는 설치 가능한 전봇대 개수만 담으므로 1차원 배열 사용 -> dp[n]
    A 연결 위치를 기준으로 정렬하고, B를 비교한다.
    만약 i-1 번째 B 위치가 i 번째 B 위치보다 작다면 설치가 가능하다.

    //구글링
    -> (전체 - 설치 가능한 전봇대 개수) 로 구하는 게 편하다.

    ex)
    1 8  dp[0] = 1
    2 2  dp[1] = 1
    3 9  dp[2] = 1 -> 2
    4 1  dp[3] = 1
    6 4  dp[4] = 1 -> 2
    7 6  dp[5] = 1 -> 2 -> 3
    ...

    3 9 가 기준이라면, (1, 8) (2, 2) 까지 탐색한 뒤
    현재 A가 3에 해당하는 dp 의 누적값과 (i-?) 에 해당하는 dp의 누적값에 +1 을 한 값을 비교하여 최댓값을 취한다.

    [점화식]
    n == 1 일 때, dp[i] = 1
    n >= 2 일 때, dp[i] = Math.max(dp[i], dp[i-?] + 1)
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());    //전깃줄의 개수
        int[][] pole = new int[n][2];   //A, B를 담을 전봇대 배열
        int[] dp = new int[n];  //설치 가능한 전봇대 개수를 누적할 배열

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            pole[i][0] = Integer.parseInt(st.nextToken());
            pole[i][1] = Integer.parseInt(st.nextToken());
        }

        //A를 기준으로 정렬
        Arrays.sort(pole, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];   //첫번째 숫자 기준 오름차순
            }
        });

        for (int i = 0; i < n; i++) {
            dp[i] = 1;  //최소 설치 개수는 1개로 초기화

            for (int j = 0; j < i; j++) {
                if (pole[i][1] > pole[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        //설치 가능한 최대 전봇대 수
        int max = 0;
        for (int num:
             dp) {
            if (max < num) {
                max = num;
            }
        }

        //전체 - 설치 가능한 최대 전봇대 수 = 없애야하는 전깃줄의 최소 개수
        bw.write(String.valueOf(n - max));
        bw.flush();
        bw.close();
    }
}
