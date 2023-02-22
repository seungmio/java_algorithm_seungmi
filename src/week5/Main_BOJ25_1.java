package week5;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ25_1 {
    /*
    files[] a b c d
    (b+c) + (a+(b+c)) + (d+(a+(b+c)))


    [점화식]
    n == 1 일 때,
    n == 2 일 때,
    n >= 3 일 때,
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());    //테스트 데이터 개수

        for (int i = 0; i < t; i++) {
            int k = Integer.parseInt(br.readLine());    //장의 수
            int[] files = new int[k];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < k; j++) {
                files[i] = Integer.parseInt(st.nextToken());
            }
        }
    }
}
