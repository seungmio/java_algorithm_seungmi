import java.io.*;

public class Main_16918 {
    static int R;
    static int C;
    static int N;
    static char[][] map;
    static  int[][] mapTime;    //폭탄 시간 체크

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        R = Integer.parseInt(input[0]);
        C = Integer.parseInt(input[1]);
        N = Integer.parseInt(input[2]);

        map = new char[R][C];
        mapTime = new int[R][C];

        for (int i = 0; i < R; i++) {
            String bomb = br.readLine();
            for (int j = 0; j < C; j++) {
                map[i][j] = bomb.charAt(j);

                if (map[i][j] == 'O') {
                    mapTime[i][j] = 3;
                }
            }
        }

        int time = 1;   //시간이 얼마나 지났는지 체크(현재 시간)
        int[] di = {1, -1, 0, 0};   //좌 우 상 하
        int[] dj = {0, 0, 1, -1};

        while (time < N) {
            time++;

            //폭탄이 설치되어 있지 않은 모든 칸에 폭탄 설치
            if (time % 2 == 0) {    //2초 지남
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (map[i][j] == '.') {
                            map[i][j] = 'O';

                            //현재 시간에서 3초 뒤
                            mapTime[i][j] = time + 3;
                        }
                    }
                }
            }

            //폭탄 폭발
            else if (time % 2 == 1) {
                for (int i = 0; i < R; i++) {
                    for (int j = 0; j < C; j++) {
                        if (mapTime[i][j] == time) { //터지는 폭탄
                            map[i][j] = '.';

                            for (int k = 0; k < 4; k++) {
                                int i1 = i + di[k];
                                int j1 = j + dj[k];

                                if (i1 >= R || j1 >= C || j1 < 0 || i1 < 0) {
                                    continue;
                                }

                                //동시에 터져야 하는 폭탄
                                if (map[i1][j1] == 'O' && mapTime[i1][j1] != time) {
                                    map[i1][j1] = '.';
                                    mapTime[i1][j1] = 0;
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
