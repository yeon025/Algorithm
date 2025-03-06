import java.util.*;


public class Main {

    public static void main(String[] args) {

        // 1) 소인수분해를 할 정수 N을 입력
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // 2) N을 소인수분해 후 출력
        int factor = 2;
        while (factor <= N) {
            if (N % factor == 0) {
                N = N / factor;
                System.out.println(factor);
                factor = 2;
            } else {
                factor++;
            }
        }
    }
}