package week0;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_Stack {
    /*
    순열을 1, 2, 3 ... N 으로 만들어야 하므로,
    숫자가 들어오는 순서대로 스택에 나눠서 넣는다.
    큰 수를 먼저 뽑아야 맨 뒤에 오게 되므로,
    나누는 기준은 들어갈 숫자가 이미 들어있는 숫자보다 커야한다.
    조건을 충족하면 스택에 넣고 아닐 시 다음 스택을 탐색한다.
    만약 4개 스택 모두 들어갈 수 없다면 false를 리턴한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        String result = "YES";

        //4개의 비어있는 스택
        //리스트에 담아 관리한다.
        List<Stack<Integer>> stackList = new ArrayList<>();

        //들어올 숫자가 1 이상 N 이하의 서로 다른 정수이므로
        //4개의 스택의 초기값을 0으로 설정한 뒤, 리스트에 담는다.
        for (int i = 0; i < 4; i++) {
            Stack<Integer> stack = new Stack<>();
            stack.push(0);
            stackList.add(stack);
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            int cnt = 0;

            for (int j = 0; j < 4; j++) {
                if (stackList.get(j).peek() < num) {
                    stackList.get(j).push(num);
                    break;
                } else {
                    cnt += 1;
                }
            }

            if (cnt == 4) {
                result = "NO";
                break;
            }
        }

        bw.write(result);
        bw.flush();
        bw.close();
    }
}

/*
5 4 3 2 1의 경우,

ex) stack 의 형태가 다음과 같다면,
      1
5 4 3 2

2 1 3 4 5 가 최선이다.
즉, 가장 작은 숫자인 1이 맨 앞에 오기 위해서 가장 나중에 꺼내야 하는데 불가능하다.
----------

4 3 6 7 8 9 10 2 1 5 의 경우,

ex) stack 의 형태가 다음과 같다면,
10
9
8
7
6 5
4 3 2 1

1 2 3 4 5 6 7 8 9 10 로 정렬된다.

 */
