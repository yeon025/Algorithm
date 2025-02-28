import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> intArray = new ArrayList<>();
        int biggestInt = 0;
        int largestOrder = 0;
        int tmp = 0;

        // 1) 9개의 서로다른 자연수를 입력
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 9; i++) {
            Integer enteredNumber = scanner.nextInt();
            intArray.add(enteredNumber);
        }

        // 2) 배열의 첫번째를 가장 큰 자연수로 설정
        biggestInt = intArray.get(0);
        largestOrder = 1;

        // 3) 배열을 순회하면서 가장 큰 자연수를 찾음
        for (int i = 1; i < 9; i++) {
            tmp = intArray.get(i);
            if (tmp > biggestInt) {
                biggestInt = tmp;
                largestOrder = i + 1;
            }
        }

        // 4) 결과 출력
        System.out.println(biggestInt);
        System.out.println(largestOrder);

    }
}