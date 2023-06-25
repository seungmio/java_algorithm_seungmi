package JavaStudy01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_9655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());    //판의 한 변의 길이
        String[] cookie = new String[n];

        for (int i = 0; i < n; i++) {
            cookie[i] = br.readLine();
        }

        //머리로 심장찾기
        //시작위치 초기화
        int x = 1;
        int y = 1;
        boolean bool = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (cookie[i].charAt(j) == '*') {
                    x = i + 2;  //행
                    y = j + 1;  //열
                    System.out.println(x + " " + y);
                    bool = true;
                    break;
                }
            }
            if (bool) {
                break;
            }
        }
        
        //왼팔
        int leftArm = 0;
        for (int i = 0; i < y - 1; i++) {
            if (cookie[x - 1].charAt(i) == '*') {
                leftArm += 1;
            }
        }

        //오른팔
        int rightArm = 0;
        for (int i = y; i < n; i++) {
            if (cookie[x-1].charAt(i) == '*') {
                rightArm += 1;
            }
        }

        //허리
        int waist = 0;
        int end = 0;    //허리 맨 아래
        for (int i = x; i < n; i++) {
            if (cookie[i].charAt(y-1) == '*') {
                waist += 1;
                end = i;
            }
        }

        //왼다리
        int leftLeg = 0;
        for (int i = end + 1; i < n; i++) {
            if (cookie[i].charAt(y-2) == '*') {
                leftLeg += 1;
            }
        }

        //오른다리 검사
        int rightLeg = 0;
        for (int i = end + 1; i < n; i++) {
            if (cookie[i].charAt(y) == '*') {
                rightLeg += 1;
            }
        }

        System.out.println(leftArm + " " + rightArm + " " + waist + " " + leftLeg + " " + rightLeg);
    }
}
