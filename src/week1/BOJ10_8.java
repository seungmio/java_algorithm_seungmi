package week1;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ10_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        /*
        < 2차원 배열 정렬 방법 >
        Comparator을 Override 하여 정렬 기준을 제시한다.
        o1[0] 이면 0번째 element를 기준으로 compare
        두 번째 요소도 고려하여 정렬을 하고 싶으면 o1[0] == o2[0] 코드 추가하여 비교
         */

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) {
                return Integer.compare(o1[1], o2[1]);
            } else {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        for (int i = 0; i < n; i++) {
            bw.write(arr[i][0] + " " + arr[i][1] + "\n");
        }

        bw.flush();
        bw.close();
    }
}
