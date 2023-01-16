package week1;//import java.util.Scanner;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ10_4 {
    public static void main(String[] args) throws IOException {
        /*
        //sort() 쓰면 시간초과 됨 -> dual-pivot Quicksort 알고리즘을 쓰는데,
        //최악의 경우 시간 복잡도가 O(n**) 이 됨.
        //최악의 경우에도 O(nlogn) 을 보장하거나 O(n) 에 가까운 정렬 알고리즘을 써야함.

        //출력할 때도 시간초과 난다.
        //한번에 출력해 줘야 시간초과 안 남
        
        //StringBuilder는 출력을 print() 로 해줘야 한다.
        //그래서 BufferedWriter 써야 함

       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = n - 1; i >= 0 ; i--) {
            System.out.println(arr[i]);
        }
         */

        //br 로 읽고, sb로 문자열 하나로 묶은 다음 bw로 출력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        //sb를 print() 말고 bw 로 출력
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(list);
        for (int num : list) {
            sb.append(num + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
