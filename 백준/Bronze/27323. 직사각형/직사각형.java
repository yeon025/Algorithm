import java.util.*;


public class Main {

    public static void main(String[] args) {

        // 1) 직사각형 두 변의 길이를 입력
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        scanner.nextLine();
        int y = scanner.nextInt();

        // 2) 직사각형 넓이 출력
        System.out.println(x*y);
    }
}