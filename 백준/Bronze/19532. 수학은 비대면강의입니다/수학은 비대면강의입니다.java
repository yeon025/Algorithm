import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {

        // 1) 정수 a, b, c, d, e, f를 입력
        // Scanner scanner = new Scanner(System.in);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // String[] array = scanner.nextLine().split(" ");
        String[] array = br.readLine().split(" ");

        int a = Integer.parseInt(array[0]);
        int b = Integer.parseInt(array[1]);
        int c = Integer.parseInt(array[2]);
        int d = Integer.parseInt(array[3]);
        int e = Integer.parseInt(array[4]);
        int f = Integer.parseInt(array[5]);




        // 2) 부르트포스로 x, y를 구함
        int x = 0;
        int y = 0;
        StringBuilder sb = new StringBuilder();

        for (int i = -999; i < 1000; i++) {
            for (int j = -999; j < 1000; j++) {
                if ((a * i + b * j == c) && (d * i + e * j == f)) {
                    x = i;
                    y = j;
                    break;
                }
            }
        }

        sb.append(x);
        sb.append(" ");
        sb.append(y);

        System.out.println(sb);
    }
}