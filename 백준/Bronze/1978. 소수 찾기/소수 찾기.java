import java.util.*;


public class Main {

    public static void main(String[] args) {

        // 1) 입력할 수의 개수 N과 N번 숫자를 입력
        Scanner scanner = new Scanner(System.in);
        scanner.nextLine();

        String[] numberArray = scanner.nextLine().split(" ");
        List<Integer> numberList = new ArrayList<>();

        for (String number : numberArray) {
            int toInt = Integer.parseInt(number);
            numberList.add(toInt);
        }


        // 2) 입력한 수가 소수인지 판별
        int factor = 2;
        int primeNumberCount = 0;
        for (int number : numberList) {
            while (factor < number) {
                if (number % factor == 0) {
                    break;
                }
                factor++;
            }
            if (factor == number) {
                primeNumberCount++;
            }
            factor = 2;
        }


        // 3) 소수의 개수 출력
        System.out.println(primeNumberCount);
    }
}