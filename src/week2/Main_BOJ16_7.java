package week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ16_7 {
    public static int n;    //수의 개수
    public static long[] arr;    //수를 담을 배열
    public static int[] operator = new int[4];   //연산자 수를 담을 배열
    //static int MAX = Integer.MIN_VALUE;    //최댓값
    //static int MIN = Integer.MAX_VALUE;    //최솟값

    static long MAX = -1100000000;
    static long MIN = 1100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        arr = new long[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        //Exception in thread "main" java.util.NoSuchElementException 오류
        // 더이상 element가 없는데도 불러오려고 할 때 발생
        st = new StringTokenizer(br.readLine());
        //+ - x ÷ 순
        for (int i = 0; i < 4; i++) {
            //연산자같은건 배열에 담아서 그냥 풀어버리자 ..
            operator[i] = Integer.parseInt(st.nextToken());
        }

        recursion(arr[0],1);

        //출력 테스트용
        //숫자 2147483647
        //-2147483648 이지랄남 왜이래 -> long 으로 초기화 해주니까 해결됨
        sb.append(MAX + "\n");
        sb.append(MIN);

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }

    //연산자 배열을 반복하면서 최대, 최솟값을 갱신해야 함
    public static void recursion(long num, int cnt) {
        //cnt 값이 n과 같아지면 모든 수가 계산된 것이므로 max, min 값을 갱신한다.
        if (cnt == n) {
            //Math 함수 -> 두 인자를 비교하여 최대, 최소값을 return
            MAX = Math.max(MAX, num);
            MIN = Math.min(MIN, num);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {  //연산자 개수가 1개 이상이어야 함.
                operator[i]--;  //해당 연산자 사용

                if (i == 0) {   //+
                    recursion(num + arr[cnt], cnt + 1);
                } else if (i == 1) { //-
                    recursion(num - arr[cnt], cnt + 1);
                } else if (i == 2) {    //*
                    recursion(num * arr[cnt], cnt + 1);
                } else if (i == 3) { // /
                    recursion(num / arr[cnt], cnt + 1);
                }

                operator[i]++;
            }
        }
    }
}
