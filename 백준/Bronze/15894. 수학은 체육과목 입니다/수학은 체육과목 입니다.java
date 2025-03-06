import java.util.*;


public class Main {

    public static void main(String[] args) {
        // 1) 맨 아래 블록의 개수 N을 입력
        Scanner scanner = new Scanner(System.in);
        long N = scanner.nextInt();

        // 2) 도형의 둘레 구하기 (N*4)
        System.out.println(N*4);
    }
}