import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_17281 {
    /*
    9명 2팀
    1이닝 = 공격, 수비 (N이닝)
    3아웃 = 종료, 공수교대
    공격 = 1루, 2루, 3루, 홈에 도착하면 1점
        안타: 타자+주자 1루 진루
        2루타: 타자+주자 2루 진루
        3루타: 타자+주자 3루 진루
        홈런: 타자+주자 홈 진루
        아웃: 진루X, 아웃+=1
     */

    static int N;   //이닝
    static int[][] team;
    static int[] player;
    static boolean[] base;
    static int out; //아웃 횟수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        team = new int[N][9];
        player = new int[9];
        base = new boolean[4];

        for (int i = 0; i < N; i++) {
            String str = br.readLine();
            for (int j = 0; j < 9; j++) {
                team[i][j] = Integer.parseInt(String.valueOf(str.charAt(j)));
            }
        }

        player[3] = 1;  //4번째 1번 선수 고정
     }
}
