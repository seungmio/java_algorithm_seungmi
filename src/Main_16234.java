import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_16234 {
    static int n;
    static int L;
    static int R;
    static int[][] country;
    static boolean[][] visit;
    static int[] dx = {-1, 0, 0, 1};    //왼 아래 위 오
    static  int[] dy = {0, -1, 1, 0};

    static void dfs(int x, int y) { //x, y는 country 현재 위치
        //현재 위치에서 이동할 수 있는 곳
        for (int i = 0; i < 4; i++) {
            int X = x + dx[i];
            int Y = y + dy[i];

            //이동이 불가할 때
            if (X < 0 || Y < 0 || X >= n || Y >= n) {
                continue;
            }

            int diff = Math.abs(country[y][x] - country[Y][X]);
            if (diff >= L && diff <= R) {   //국경선 조건 성립
                visit[y][x] = true; //방문
                if (visit[Y][X]) { //방문할 국가가 이미 방문한 국가일 때
                    continue;
                } else {
                    dfs(X, Y);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        country = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }


    }
}
