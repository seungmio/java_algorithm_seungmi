package week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ16_2 {
    public static boolean[] isChecked;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        isChecked = new boolean[n];
        arr = new int[m];
        recursion(n, m, 0);
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }

    public static void recursion(int n, int m, int cnt) {
        if (cnt == m) {
            for (int i: arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isChecked[i]) {
                isChecked[i] = true;
                arr[cnt] = i + 1;
                recursion(n, m, cnt + 1);

                for (int j = i + 1; j < n; j++) {
                    //1 번과 달리 i = 2 라면
                    // 1, 2 는 true 이고 3, 4만 false 이어야 하기 때문에
                    isChecked[j] = false;
                }
            }
        }
    }
}
