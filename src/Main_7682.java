import java.io.*;

public class Main_7682 {

    static char[][] ttt;
    static int Xrow, Xcol, Xcross;  //x 가로, 세로, 대각선
    static int Orow, Ocol, Ocross;  //o 가로, 세로, 대각선

    public static void main(String[] args) throws IOException {
        /*
        1. 가로, 세로, 대각선 검사해서 빙고 있는지 검사
        2. 같은 라인에 빙고 2개 이상 X (끝내야하는데 안끝낸거임)
        3. x개수가 더 크다면 x가 이겨야 함(x가 먼저 놓으니까)
        4. x와 o의 개수가 같다면 xoxoxo ?
        x.o
        o..
        x..
        5. 빙고가 존재해야만 한다.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String piece = br.readLine();
            
            if (piece.equals("end")) { break; } //게임 종료
            
            //빙고 개수 초기화
            Xrow = 0;
            Xcol = 0;
            Xcross = 0;
            Orow = 0;
            Ocol = 0;
            Ocross = 0;
            
            ttt = new char[3][3];   //빙고판 초기화
            
            int Xcnt = 0;   //x개수
            int Ocnt = 0;   //O개수
            int idx = 0;   
            
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    ttt[i][j] = piece.charAt(idx);
                    idx++;
                    
                    if (ttt[i][j] == 'X') {
                        Xcnt++;
                    } else if (ttt[i][j] == 'O') {
                        Ocnt++;
                    }
                }
            }

            //X, O 개수 검사
            //O 개수가 더 크거나 X,O 개수 차이가 2 이상이면 안된다.
            if (Ocnt > Xcnt || Math.abs(Ocnt-Xcnt) > 1) {
                System.out.println("invalid");
            }

            //빙고 검사
            for (int i = 0; i < 3; i++) {//가로, 세로
                int rowX = 0;
                int colX = 0;
                int rowO = 0;
                int colO = 0;

                for (int j = 0; j < 3; j++) {
                    if (ttt[i][j] == 'X') { rowX++; }
                    else if (ttt[i][j] == 'O') { rowO++; }
                    if (ttt[j][i] == 'X') { colX++; }
                    else if (ttt[j][i] == 'O') { colO++; }

                    if (rowX == 3) { Xrow++; }
                    else if (rowO == 3) { Orow++; }
                    else if (colX == 3) { Xcol++; }
                    else if (colO == 3) { Ocol++; }
                }
            }


            int crossX = 0;
            int crossO = 0;

            for (int i = 0; i < 3; i++) {//대각선
                if (ttt[i][i] == 'X') { crossX++; }
                else if (ttt[i][i] == 'O') { crossO++; }

                if (crossX == 3) { Xcross++; }
                if (crossO == 3) { Ocross++; }
            }

            crossX = 0;
            crossO = 0;
            //(0,2) (1,1) (2,0)
            for (int i = 2; i >= 0 ; i--) {
                if (ttt[2-i][i] == 'X') { crossX++; }
                else if (ttt[2-i][i] == 'O') { crossO++; }

                if (crossX == 3) { Xcross++; }
                if (crossO == 3) { Ocross++; }
            }

            //X개수가 더 크다면 X가 이겨야 함
            if (Xcnt > Ocnt) {
                if (Orow > 0 || Ocol > 0 || Ocross > 0) {
                    System.out.println("invalid");
                }
            }
            //o개수가 더 크다면?
            //빙고가 없다면
            if (Xcross + Xcol + Xrow + Ocross + Orow + Ocol == 0) {
                System.out.println("invalid");
            }
        }
    }
}
