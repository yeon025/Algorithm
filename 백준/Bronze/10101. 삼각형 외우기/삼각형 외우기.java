import java.util.*;


public class Main {

    public static void main(String[] args) {
        // 1) 3개의 각을 입력
        Scanner scanner = new Scanner(System.in);

        int tmp = 0;
        List<Integer> angle = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            tmp = scanner.nextInt();
            scanner.nextLine();
            angle.add(tmp);
        }

        // 2-1) 60이라면 Equilateral
        // 2-2) 전체가 180이고 두 각이 같다면 Isosceles
        // 2-3) 전체가 180이고 같은 각이 없다면 Scalene
        // 2-4) 세 각의 합이 다르면 Error
        int firstAngle = angle.get(0);
        int secondAngle = angle.get(1);
        int thirdAngle = angle.get(2);

        if ((firstAngle + secondAngle + thirdAngle) != 180) {
            System.out.println("Error");
            return;
        }

        if ((firstAngle == secondAngle) && (secondAngle == thirdAngle)) {
            System.out.println("Equilateral");
        } else if ((firstAngle == secondAngle) || (secondAngle == thirdAngle) || (firstAngle == thirdAngle)) {
            System.out.println("Isosceles");
        } else {
            System.out.println("Scalene");
        }

    }
}