import java.util.*;


public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int longest = 0;
        int excludeCalculation = 0;
        int notHypotenuseLength = 0;
        int[] lengthArrray = new int[3];

        while (true) {

            // 1) 세 변의 길이를 입력
            String[] array = scanner.nextLine().split(" ");
            lengthArrray[0] = Integer.parseInt(array[0]);
            lengthArrray[1] = Integer.parseInt(array[1]);
            lengthArrray[2] = Integer.parseInt(array[2]);


            // 2) 0 0 0을 입력하면 종료
            if (lengthArrray[0] == 0 && lengthArrray[1] == 0 && lengthArrray[2] == 0) {
                break;
            }


            // 3) 가장 긴 길이를 구함
            longest = lengthArrray[0];
            excludeCalculation = 0;

            if (longest < lengthArrray[1]) {
                longest = lengthArrray[1];
                excludeCalculation = 1;
            }
            if (longest < lengthArrray[2]) {
                longest = lengthArrray[2];
                excludeCalculation = 2;
            }


            // 4) 세 변의 길이가 삼각형의 조건을 만족하지 못하는 경우에는 "Invalid" 를 출력
            notHypotenuseLength = 0;

            for (int i = 0; i < 3; i++) {
                if (i == excludeCalculation) {
                    continue;
                }
                notHypotenuseLength = notHypotenuseLength + lengthArrray[i];
            }

            if (longest >= notHypotenuseLength) {
                System.out.println("Invalid");
                continue;
            }


            // 5-1) Equilateral :  세 변의 길이가 모두 같은 경우
            // 5-2) Isosceles : 두 변의 길이만 같은 경우
            // 5-3) Scalene : 세 변의 길이가 모두 다른 경우
            if ((lengthArrray[0] == lengthArrray[1]) && (lengthArrray[0] == lengthArrray[2])) {
                System.out.println("Equilateral");
            } else if ((lengthArrray[0] == lengthArrray[1]) || (lengthArrray[0] == lengthArrray[2]) ||
                (lengthArrray[1] == lengthArrray[2])) {
                System.out.println("Isosceles");
            } else {
                System.out.println("Scalene");
            }
        }
    }
}