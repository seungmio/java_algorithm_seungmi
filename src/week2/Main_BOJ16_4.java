package week2;

import java.io.*;
import java.util.StringTokenizer;

public class Main_BOJ16_4 {

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
                arr[cnt] = i + 1;   //[0, 0] -> [1, 0]
                //자식 노드는 부모 노드의 boolean 값이 t 이기 때문에 방문하지 않는다.
                recursion(n, m, cnt + 1);   //자식 노드 방문을 위해 cnt 1 증가 후 호출
                
                //같은 수 출력을 위해 재귀함수 호출 후 방문 표시
                isCheck[i] = true;
                
                //같은 수를 제외하고 중복 수열을 여러번 출력하면 안되기 때문
                for (int j = i + 1; j < n; j++) {
                    isCheck[j] = false;
                }
            }
        }
    }
}
