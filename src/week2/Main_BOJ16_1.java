package week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ16_1 {
    /*
    [ 백트래킹 ]
    재귀적으로 문제를 하나씩 풀어나가되,
    현재 재귀를 통해 확인 중인 상태(노드)가 제한 조건에 위배되는지(유망하지 않은지) 판단하고
    그러한 경우 해당 상태(노드)를 제외하고 다음 단계로 나아가는 방식이다.
    특정 상태(노드)를 제외한다는 것
    DFS(깊이우선탐색), BFS(너비우선탐색)
    DFS -> 트리에서 바닥에 도달할 때까지 한 쪽 방향으로만 내려가는 방식
    재귀함수나 스택으로 구현
    깊이가 무한인 경우 빠져나오지 못함
    BFS -> 모든 분기점을 다 검사하면서 진행
    큐로 구현 (새로운 경우를 큐에 집어넣고, 검사한 원소는 큐에서 뺀다.)
     */

    public static boolean[] isCheck;
    public static int[] arr;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //1~n까지 자연수
        int m = Integer.parseInt(st.nextToken());   //길이가 m

        isCheck = new boolean[n]; //이미 방문한 노드인지 검사하기 위한 배열
        arr = new int[m]; //출력할 배열
        recursion(n, m, 0);
        bw.write(String.valueOf(sb));

        bw.flush();
        bw.close();
    }

    public static void recursion(int n, int m, int cnt) {    //재귀함수

        if (cnt == m) { //깊이가  m과 같아지면 출력
            for (int i: arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!isCheck[i]) {  //만약 방문한 노드가 아니라면
                isCheck[i] = true;  //방문한 노드로 변경 [f, f, f, f] -> [t, f, f, f]
                arr[cnt] = i + 1;   //[0, 0] -> [1, 0]
                //자식 노드는 부모 노드의 boolean 값이 t 이기 때문에 방문하지 않는다.
                recursion(n, m, cnt + 1);   //자식 노드 방문을 위해 cnt 1 증가 후 호출

                //자식 노드 방문이 끝나면 부모 노드를 방문하지 않은 노드로 변경해야 한다.
                //변경하지 않으면 [2, 0], [2, 1] ... 출력이 불가능하다.
                isCheck[i] = false;
            }
        }
    }
}
