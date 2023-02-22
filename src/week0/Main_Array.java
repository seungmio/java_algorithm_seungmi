package week0;

import java.io.*;
import java.util.Arrays;

public class Main_Array {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String S = br.readLine();
        String[] arr = new String[S.length()];  //접미사를 담을 배열
        int cnt = 0;    //배열 index

        while (true) {
            String s = "";
            for (int i = cnt; i < S.length(); i++) {
                s += S.charAt(i);
            }
            arr[cnt++] = s;

            if (cnt == S.length()) {
                break;
            }
        }

        Arrays.sort(arr);
        for (String string: arr) {
            sb.append(string).append("\n");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
