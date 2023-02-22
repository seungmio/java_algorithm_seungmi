package week0;

import java.io.*;
import java.util.*;

public class Main_Queue {
    /*
    1. 첫 번째 원소를 front 에서 뽑는다.
    2. 왼쪽으로 한 칸 이동 a1, ... ak -> a2, ... ak, a1
    3. 오른쪽으로 한 칸 이동 a1, ... ak -> ak, a1, ... ak-1

    N 큐의 크기(~50), M 뽑아내려고 하는 수의 개수
    뽑아내려고 하는 수의 위치

    1. 찾고자 하는 원소가 중간 지점보다 앞에 있을 경우, 2번 연산을 수행한다.
    2. 찾고자 하는 원소가 중간 지점보다 뒤에 있을 경우, 3번 연산을 수행한다.
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());    //큐의 크기
        int m = Integer.parseInt(st.nextToken());    //뽑아내려고 하는 수의 개수

        LinkedList<Integer> deque = new LinkedList<>(); //덱큐
        int[] arr = new int[m]; //뽑아낼 수를 담을 배열

        for (int i = 1; i <= n; i++) {
            deque.offer(i);   //queue에 값 추가
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            arr[i] = Integer.parseInt(st.nextToken());  //배열에 값 추가
        }

        int cnt = 0;    //2, 3번 연산 횟수 누적
        int mid;    //중간 위치

        for (int i = 0; i < m; i++) {
            //중간 위치
            if (deque.size() % 2 == 0) {
                mid = deque.size() / 2 - 1;
            } else {
                mid = deque.size() / 2;
            }

            //찾고자 하는 원소 위치
            int target = deque.indexOf(arr[i]);

            if (target <= mid) { //찾고자 하는 원소가 중간 지점보다 앞에 있을 경우
                for (int j = 0; j < target; j++) {
                    //num보다 앞에 있는 수를 모두 뒤로 보낸다.
                    deque.offerLast(deque.pollFirst());
                    cnt += 1;
                }
            } else  {  //찾고자 하는 원소가 중간 지점보다 뒤에 있을 경우
                for (int j = 0; j < deque.size() - target; j++) {
                    //num보다 뒤에 있는 수를 모두 앞으로 보낸다.
                    deque.offerFirst(deque.pollLast());
                    cnt += 1;
                }
            }

            deque.pollFirst();  //연산이 끝나면 뽑으려는 수가 맨 앞에 있으므로
        }

        bw.write(String.valueOf(cnt));
        bw.flush();
        bw.close();
    }
}
