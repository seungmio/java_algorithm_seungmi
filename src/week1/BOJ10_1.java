package week1;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class BOJ10_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();   //수의 개수
        int[] num = new int[n];

        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);

        for (int i = 0; i < n; i++) {
            System.out.println(num[i]);
        }
    }
}
