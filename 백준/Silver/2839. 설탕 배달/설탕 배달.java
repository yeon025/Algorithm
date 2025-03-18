import java.util.*;


public class Main {

    public static void main(String[] args) {
        // 1) 설탕의 총 kg 입력
        Scanner scanner = new Scanner(System.in);
        int totalKg = scanner.nextInt();


        // 2) 설탕 자루 수 계산
        int bagCount = 0;

        while (totalKg > 0) {
            if ((totalKg == 1) || (totalKg == 2) || (totalKg == 4)) {
                bagCount = -1;
                break;
            }


            if ((totalKg - 5 == 3) || (totalKg - 5 == 6) || (totalKg - 5 == 9) || (totalKg - 5 == 12)) {
                totalKg = totalKg - 5;
                bagCount++;
                // System.out.println(5 + " " + bagCount + " " + totalKg);

                bagCount = bagCount + (totalKg / 3);
                // System.out.println(3 + " " + bagCount + " " + totalKg % 3);

                break;
            } else if ((totalKg <= 12) && (totalKg % 3 == 0)) {
                bagCount = bagCount + totalKg / 3;
                break;
            }
            totalKg = totalKg - 5;

            bagCount++;
            // System.out.println(5 + " " + bagCount + " " + totalKg);
        }


        // 3) 최소 자루 출력
        System.out.println(bagCount);
    }
}