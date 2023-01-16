package week1;

import java.util.Arrays;
import java.util.Scanner;

public class BOJ10_2 {
    public static void main(String[] args) {
        int[] num = new int[5];
        Scanner sc = new Scanner(System.in);
        int mid = 0;    //중앙값
        int avg = 0;    //평균

        for (int i = 0; i < 5; i++) {
            num[i] = sc.nextInt();
        }

        Arrays.sort(num);
        mid = num[2];

        for (int n : num) {
            avg += n;
        }

        System.out.println(avg / 5);
        System.out.println(mid);

    }
}
