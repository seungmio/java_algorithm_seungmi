package week4;

import java.io.*;

/*
1. 데이터 내 최대화 / 최소화 계산을 하거나 특정 조건 내 데이터를 세야 한다거나 확률 등의 계산 -> DP
2. 변수 파악
    1. 피보나치 수열 - n 번째 숫자
    2. 문자열 간의 차이 - 문자열의 길이, Edit 거리
    3. Knapsack 문제 - index, 무게
3. 변수 간 관계식 (점화식)
    동일한 변수값인 경우 결과가 동일 그 결과값을 그대로 이용하는 관계식
4. 메모
    변수의 값에 따른 결과 저장 (배열)
 */
public class Main_BOJ17_1 {
    /*
    12일 때
    3으로 나눌 때, arr[12] = arr[4] + 1 (연산 횟수니까)
    2로 나눌 때, arr[12] = arr[6] + 1
    1을 뺄 때, arr[12] = arr[11] + 1
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 0;

        for (int i = 2; i <= n; i++) {
            arr[i] = arr[i - 1] + 1;    //어쩌라고 5같은 숫자 들어오면 처리해줘야해서 무조건 빼야함
            if (i % 2 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 2] + 1);
            }
            if (i % 3 == 0) {
                arr[i] = Math.min(arr[i], arr[i / 3] + 1);
            }
        }

        bw.write(String.valueOf(arr[n]));
        bw.flush();
        bw.close();
    }
}
