package week1;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ10_10 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];

        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() == o2.length()) {   //길이가 같으면
                    return o1.compareTo(o2);    //사전순 정렬
                } else {
                    return o1.length() - o2.length();   //그 외 길이순 정렬
                }
            }
        });

        sb.append(arr[0] + "\n");
        for (int i = 1; i < n; i++) {
            //중복되지 않은 단어
            if (!arr[i].equals(arr[i - 1])) {
                sb.append(arr[i] + " \n");
            }
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
