package week1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class BOJ10_6 {
    public static void main(String[] args) throws IOException {
        /*
        반복문을 돌면서 해당 숫자 값의 index를 1 증가 시켜주는 방법
        수의 범위가 매우 넓고 (절댓값 4000), 음수도 처리해 주어야 한다.

        배열 크기를 8001로 초기화 해놓고 (배열 안쓰고 푸는 방법이 없는 것 같다.)
        만약 음수이면 * (-1) + 4000 값을 1 증가
        양수이면 값을 1 증가

        배열을 돌면서 가장 높은 빈도수를 찾는다.
        값을 담을 list를 선언하고,
        그 값이 음수 ( > 4000) 이면 * (-1) - 4000 을 list 에 add 하고
        양수이면 값을 list에 add 한다.
        list size 가 2 이상이면 최빈값이 여러개 라는 뜻이므로 list.get(1) 을 출력해야 2번째로 작은 값이 나온다.
        size가 1 이면 list.get(0) 하면 된다.
         */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();

        int[] arr = new int[8001];  //입력된 각 정수 개수를 담을 배열
        ArrayList<Integer> mList = new ArrayList<>();   //최빈값을 담을 list

        int avg = 0;    //산술평균
        int mid = 0;    //중앙값
        int mode = 0;    //최빈값
        int range = 0;  //범위
        
        //최빈값 구하기
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            list.add(num);

            if (num < 0) {
                arr[num * (-1) + 4000]++;
            } else {
                arr[num]++;
            }
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
        }

        //2번째 들어간순간에 바로 출 .. . 력? . .. . .. . .....
        for (int i = 0; i < arr.length; i++) {
            if (max == arr[i]) {
                if (i > 4000) {
                    mList.add((i - 4000) * (-1));
                } else {
                    mList.add(i);
                }
            }
        }

        Collections.sort(mList);
        if (mList.size() >= 2) {
            mode = mList.get(1);
        } else {
            mode = mList.get(0);
        }

        Collections.sort(list); //list 정렬

        //List<Integer> 값을 합치려면 stream 기법을 사용하면 된다.
        //리스트.stream().mapToInt(Integer::intValue).sum(); -> 쓰지말란다
        //mapToDouble로 할 수 있나?
        //Math.round() 안쓰고 format으로 반올림하면 -0 나올수도 있다.
        avg = (int) Math.round((double) list.stream().mapToInt(Integer::intValue).sum() / n);
        mid = list.get(n / 2);
        range = list.get(n - 1) - list.get(0);

        sb.append(avg + "\n");
        sb.append(mid + "\n");
        sb.append(mode + "\n");
        sb.append(range);
        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();
    }
}
