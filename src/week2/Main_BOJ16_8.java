package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_BOJ16_8 {
    /*
    12 / 34 -> (1,2 + 2,1), (3,4 + 4,3)
    가능한 모든 스타트 팀과 링크 팀의 능력치를 구해서 그 차이의 최솟값을 계산
     */
    static int n;   //n 명
    static int[][] arr;   //n * n 배열
    static boolean[] isCheck;   //1 ~ n 까지 방문 유무 검토
    static int MIN = Integer.MAX_VALUE;   //두 팀의 능력치 최솟값

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        isCheck = new boolean[n];

        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        recursion(0, 0);
        System.out.println(MIN);
    }

    public static void recursion(int num, int cnt) {
        if (cnt == n / 2) { //두 팀으로 나누어 능력치 합을 구한다. (무조건 짝수)
            /*
            조건문 안에 전부 구현하지 말고 따로 함수로 정리하자
            여기서도 long 문제 생겨서 검색함.
             */
            diff(); //능력치 차이를 구하는 함수
            return;
        }

        for (int i = num; i < n; i++) {
            if (!isCheck[i]) {  //방문하지 않은 사람이라면
                isCheck[i] = true;  //방문한 사람으로 변경
                recursion(i + 1,cnt + 1);   //미친놈 .. 이거 i+1임;;
                isCheck[i] = false;
            }
        }
    }

    public static void diff() {
        int start = 0;  //스타트 팀 능력치
        int link = 0;   //링크 팀 능력치

        // [0, 0] .. [3, 4] 를 방지하기 위해 i, j 초기화 (1번만 탐색)
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isCheck[i] && isCheck[j]) { //i, j 가 모두 true 면,
                    //스타트 팀으로 합계
                    start += arr[i][j];
                    start += arr[j][i];
                } else if (isCheck[i] == false && isCheck[j] == false) {   //i, j 가 모두 false 면,
                    //링크 팀으로 합계
                    link += arr[i][j];
                    link += arr[j][i];
                }
            }
        }

        //차이
        //System.out.println(start);
        //System.out.println(link);
        int diff = Math.abs(start - link);
        MIN = Math.min(diff, MIN);
    }
}
