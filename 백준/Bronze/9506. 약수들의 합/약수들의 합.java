import java.util.*;


public class Main {

    public static void printPerfectNumber(int isPerfectNumber, int number, int divisorPosition, List<Integer> divisor) {
        if (isPerfectNumber == number) {
            System.out.print(number + " = ");

            while (divisor.get(divisorPosition) != number) {
                System.out.print(divisor.get(divisorPosition));
                if (divisor.get(divisorPosition + 1) != number) {
                    System.out.print(" + ");
                }
                divisorPosition++;
            }
            System.out.println();
        } else {
            System.out.println(number + " is NOT perfect.");
        }
    }


    public static void main(String[] args) {

        // 1) while 문으로 숫자 n을 입력
        Scanner scanner = new Scanner(System.in);
        List<Integer> numberList = new ArrayList<>();

        while (true) {
            int n = scanner.nextInt();
            if (n == -1) {
                break;
            }
            numberList.add(n);
        }


        // 2) n의 약수를 배열에 저장
        int factor = 1;
        List<Integer> divisor = new ArrayList<>();

        for (int number : numberList) {
            factor = 1;
            while (factor <= number) {
                if (number % factor == 0) {
                    divisor.add(factor);
                }
                factor++;
            }
        }
        // System.out.println(divisor);


        // 3) 완전수인지 판별 후 결과 출력
        int i = 0;
        int divisorNumber = 0;
        int isPerfectNumber = 0;
        int divisorPosition = 0;

        for (int number : numberList) {
            divisorPosition = i;
            isPerfectNumber = 0;

            while (divisor.get(i) != number) {
                divisorNumber = divisor.get(i);
                isPerfectNumber = isPerfectNumber + divisorNumber;
                i++;
            }
            printPerfectNumber(isPerfectNumber, number, divisorPosition, divisor);
            i++;
        }
    }
}