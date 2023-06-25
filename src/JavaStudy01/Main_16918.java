package JavaStudy01;

/*
좌우상하로 이동하는 패턴
di = {-1, 1, 0, 0}
dj = {0, 0, 1, -1}
 */

import java.io.*;

public class Main_16918 {
    //0초
    //1초: 아무 일도 벌어지지 않음
    //2초: 폭탄이 설치되어 있지 않은 모든 칸에 폭탄 설치
    //3초: 3초 전에 설치된 폭탄이 모두 폭발(인접한 네 칸 폭발)
    //4초: 폭탄이 설치되어 있지 않은 모든 칸에 폭탄 설치
    //5초: 3초 전에 설치된 폭탄이 모두 폭발(인접한 네 칸 폭발)
    // ...
    static int R;
    static int C;
    static int N;
    static char[][] map;
    static int[][] mapTime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] arr = br.readLine().split(" ");
        R = Integer.parseInt(arr[0]);
        C = Integer.parseInt(arr[1]);
        N = Integer.parseInt(arr[2]);

        map = new char[R][C];
        mapTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = str.charAt(j);

                if (map[i][j] == 'O') {
                    mapTime[i][j] = 3;
                }
            }
        }

        int time = 1;   //현재 시간 저장
        int[] di = {-1, 1, 0, 0};
        int[] dj = {0, 0, 1, -1};

        while (time < N) {
            time++;

            if (time % 2 == 0) {    //2초, 4초, ...
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';
                            mapTime[i][j] = time + 3;   //현재 시간에서 3초 뒤
                        }
                    }
                }
            } else if (time % 2 == 1) { //3초, 5초, ...
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (mapTime[i][j] == time) {
                            map[i][j] = '.';

                            for (int k = 0; k < 4; k++) {
                                int diMove = i + di[k];
                                int djMove = j + dj[k];

                                if (diMove < 0 || diMove >= R || djMove < 0 || djMove >= C) {
                                    continue;
                                }

                                else if (map[diMove][djMove] == 'O' && mapTime[diMove][djMove] != time) {
                                    map[diMove][djMove] = '.';
                                    mapTime[diMove][djMove] = 0;
                                }
                            }
                        }
                    }
                }
            }
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                bw.write(String.valueOf(map[i][j]));
            }
            bw.write("\n");
        }
        bw.close();
    }
}
