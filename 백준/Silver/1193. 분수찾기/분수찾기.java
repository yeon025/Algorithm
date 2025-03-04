import java.util.*;



public class Main {

    public static void main(String[] args) {

        // 1) X 입력
        Scanner scanner = new Scanner(System.in);
        int X = scanner.nextInt();

        // 2) up이 true인지 false인지에 따라
        // true 일 때, 1/A 이라면 1/A+1    ||   L--/R++
        // false 일 때, A/1 이라면 A+1/1   ||   L++/R--
        boolean up = true;
        int leftNumber = 1;
        int rightNumber = 1;
        int i = 2;

        while (i <= X) {
            if (up) {
                while (leftNumber != 1 && i <= X) {
                    leftNumber--;
                    rightNumber++;
                    i++;
                }
                if (i <= X) {
                    rightNumber++;
                }
            } else {
                while (rightNumber != 1 && i <= X) {
                    leftNumber++;
                    rightNumber--;
                    i++;
                }
                if (i <= X) {
                    leftNumber++;
                }
            }
            i++;
            up = !up;
        }

        // 3) 결과 출력
        System.out.println(leftNumber + "/" + rightNumber);
    }
}