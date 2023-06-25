package JavaStudy01;

import java.io.*;
import java.util.*;

public class Main_1446 {
     static class Road {
         int from;
         int to;
         int dist;
         public Road(int from, int to, int dist) {
             this.from = from;
             this.to = to;
             this.dist = dist;
         }
     }
    /*
    지름길 이용과 고속도로 이용 거리 중 더 짧은 것을 택한다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());   //지름길 개수
        int d = Integer.parseInt(st.nextToken());  //고속도로 길이
        List<Road> path = new ArrayList<>();    //지름길 시작, 끝, 길이를 담는 list

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            if (e > d) continue;    //역주행 불가
            if (e-s <= l) continue; //지름길이 아님
            path.add(new Road(s, e, l));
        }

        int[] dp = new int[d + 1];  //이동한 거리를 누적하는 배열
        Arrays.fill(dp, Integer.MAX_VALUE); //최댓값으로 초기화
        dp[0] = 0;  //시작 위치는 0

        int move = 0;   //이동한 거리(dp를 기르키는 변수)
        int idx = 0;    //path의 idx를 가르키는 변수
        while (move < d) {
            if (idx < path.size()) {
                Road road = path.get(idx);
                if (move == road.from) {
                    dp[road.to] = Math.min(dp[move] + road.dist, dp[road.to]);  //지름길로 가는 길과 누적되어 있는 값 비교
                    idx++;
                } else {
                    dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);    //누적되어 있는 값과
                    move++;
                }
            } else {
                dp[move + 1] = Math.min(dp[move + 1], dp[move] + 1);
                move++;
            }
        }
        bw.write(String.valueOf(dp[d]));
        bw.flush();
        bw.close();
    }
}
