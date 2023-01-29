package week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ16_3 {
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

        //브루트포스 전체탐색이라 굳이 isCheck 확인하지 않아도 된다.
        for (int i = 0; i < n; i++) {
            if (!isCheck[i]) {  //만약 방문한 노드가 아니라면
                //isCheck[i] = true;  //방문한 노드로 변경 [f, f, f, f] -> [t, f, f, f]
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
