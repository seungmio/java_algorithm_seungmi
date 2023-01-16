package week1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //응시자 수
        int k = sc.nextInt();   //상을 받는 사람의 수
        Integer[] stdt = new Integer[n];

        for (int i = 0; i < n; i++) {
            stdt[i] = sc.nextInt();
        }

        Arrays.sort(stdt, (il, i2) -> i2 - il); //내림차순 정렬
        System.out.println(stdt[k - 1]);
    }
}
