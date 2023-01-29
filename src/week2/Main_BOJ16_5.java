package week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_BOJ16_5 {
    /*
    [ 8 - Queen ]
    퀸은 상하좌우, 대각선 4방향으로 거리 제한 없이 이동할 수 있다.
    서로의 퀸이 움직이는 경로에 다른 퀸이 있어서는 안 된다.
    같은 행, 열, 대각선에 다른 퀸을 놓을 수 없다.

    만약 퀸의 개수가 n 개가 되면 경우의 수를 1 증가시키고 return
    2중 반복을 돌면서 같은 행, 열, 오른쪽/왼쪽 대각선에 퀸이 있는지 검토한다.
    검토 후 true 값이 return 되면 퀸의 개수를 증가하고 재귀함수를 반복한다.

    1차원 배열로 풀 수 있다.
    행이 index가 되고 배열의 값이 열이 된다.
     */

    public static int result;   //경우의 수
    public static int n;
    public static boolean[][] queen;    //퀸의 방문 유무를 확인할 2차원 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        recursion(0);

        System.out.println(result);
    }
    public static void recursion(int cnt) {
        if (cnt == n) {
            result++;
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                queen[i][j] = true; //queen 자리 방문으로 변경
                if (possible(i, j)) {
                    recursion(cnt + 1);
                }
            }
        }
    }
    public static boolean possible(int row, int col) {
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                //행이 같을 때
                if (queen[i] == queen[row]) {
                    return false;
                }

                //열이 같을 때
                else if (queen[i][j] == queen[i][col]) {
                    return false;
                }

                //대각선이 같을 때
               else if ((row + col) == (i + j)) { //오른쪽 대각선 방향이 같을 때 (행+열이 같음)
                    return false;
                } else if (Math.abs(row - col) == Math.abs(i - j)) {    //왼쪽 대각선 방향이 같을 때 (행-열이 같음)
                    return false;
                }
            }
        }
        return true;
    }
}
