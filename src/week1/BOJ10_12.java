package week1;

import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ10_12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n]; //원래 배열
        int[] arr2 = new int[n];    //정렬 배열
        HashMap<Integer, Integer> hashMap = new HashMap<Integer, Integer>();

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i = 0; i < n; i++) {
            arr[i] = arr2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr2);

        //중복 처리 안하면 3인데 4로 나옴
        //hashmap에서 해당 key값이 이미 있는지 판별하는 containsKey() 사용
        int rank = 0;
        for (int i: arr2) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, rank);
                rank++;
            }
        }

        for (int i = 0; i < n; i++) {
            arr[i] = hashMap.get(arr[i]);
            sb.append(arr[i] + " ");
        }

        bw.write(String.valueOf(sb));
        bw.flush();
        bw.close();

        /*
        제일 작은 값이 0, 다음으로 큰 수부터 +1
        원래 값을 key로 새로 부여된 값을 value로 하고
        key 기준으로 오름차순 정렬한 뒤에 해당 index를 value로 가진다.
        (배열 2개 필요할 듯?)
        원래 배열, 새로운 배열 만들어서 원래 배열 key 값 찾아서 거기에 value 할당해주기
        중복은 같은 값으로 처리
         */

    }
}
