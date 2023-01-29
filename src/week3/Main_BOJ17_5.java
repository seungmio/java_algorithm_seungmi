package week3;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_BOJ17_5 {
    public static int max;
    public static int arr1[];   //입력값을 담을 배열
    public static int arr2[];   //최댓값 탐색에 이용할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        arr1 = new int[n];
        arr2 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = Integer.parseInt(st.nextToken());
        }

        max = arr1[0];
        arr2[0] = arr1[0];

        bw.write(String.valueOf(add(n)));
        bw.flush();
        bw.close();

    }
    public static int add(int n) {
        for (int i = 1; i < n; i++) {
            if (arr2[i - 1] + arr1[i] < arr1[i]) { //누적+현재 합보다 현재가 더 크다면
                arr2[i] = arr1[i];  //현재 값으로 갱신
            } else {    //누적+현재가 더 크다면
                arr2[i] = arr2[i - 1] + arr1[i];    //누적+현재로 갱신
            }

            if (max < arr2[i]) {
                max = arr2[i];
            }
        }

        return max;
    }
}
