import java.util.*;


public class Main {

    public static void main(String[] args) {

        // 1) 한수가 있는 좌표(x,y)와 직사각형의 우측 상단의 좌표(w,h)를 입력
        Scanner scanner = new Scanner(System.in);
        String[] coordinate = scanner.nextLine().split(" ");

        int x = Integer.parseInt(coordinate[0]);
        int y = Integer.parseInt(coordinate[1]);
        int w = Integer.parseInt(coordinate[2]);
        int h = Integer.parseInt(coordinate[3]);


        // 2) x-w의 절대값과 x 중에 더 짧은 길이를 선택
        int horizontal = 0;
        if (Math.abs(x-w) < x) {
            horizontal = Math.abs(x-w);
        } else {
            horizontal = x;
        }


        // 3) y-h의 절대값과 y 중에 더 짧은 길이를 선택
        int vertical = 0;
        if (Math.abs(y-h) < y) {
            vertical = Math.abs(y-h);
        } else {
            vertical = y;
        }

        
        // 4) 2의 결과와 3의 결과 중 더 짧은 길이를 선택
        if (horizontal < vertical) {
            System.out.println(horizontal);
        } else {
            System.out.println(vertical);
        }
    }
}