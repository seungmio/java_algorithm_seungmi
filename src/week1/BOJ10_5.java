package week1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ10_5 {
    // 메모리 부족
    //중복이 허용된 정렬은 카운팅 정렬을 사용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> arr = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            arr.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(arr);
        for (int num: arr) {
            sb.append(num + "\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

    }
}
