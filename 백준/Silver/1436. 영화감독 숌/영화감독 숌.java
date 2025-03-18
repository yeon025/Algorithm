import java.util.*;


public class Main {

    public static void main(String[] args) {
        // 1) 영화 제목 N을 입력
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();


        // 2) 브루트포스로 666이 들어간 수를 구함
        int bruteForce = 666;
        List<Integer> nthMovie = new ArrayList<>();
        String toString;
        int digits = 0;
        int firstDigit;
        int secondDigit;
        int thirdDigit;

        while (nthMovie.size() != N) {
            toString = Integer.toString(bruteForce);

            while (toString.length() - 2 > digits) {
                firstDigit = toString.charAt(digits) - 48;
                secondDigit = toString.charAt(digits + 1) - 48;
                thirdDigit = toString.charAt(digits + 2) - 48;

                if ((firstDigit == 6) && (secondDigit == 6) && (thirdDigit == 6)) {
                    nthMovie.add(bruteForce);
                    // System.out.println(bruteForce);
                    break;
                }
                digits++;
            }

            digits = 0;
            bruteForce++;
        }
        

        // 3) N번째 영화의 제목에 들어간 수를 출력
        System.out.println(bruteForce - 1);
    }
}