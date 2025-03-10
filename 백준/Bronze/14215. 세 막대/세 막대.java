import java.util.*;


public class Main {

    public static void main(String[] args) {
        int[] length = new int[3];
        int longest = 0;
        int excludeCalculate = 0;
        int notHypotenuseLength = 0;
        int perimeter = 0;

        
        // 1) 막대 길이 입력
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        length[0] = Integer.parseInt(array[0]);
        length[1] = Integer.parseInt(array[1]);
        length[2] = Integer.parseInt(array[2]);


        // 2) 가장 길이 구하기
        longest = length[0];

        if (longest < length[1]) {
            longest = length[1];
            excludeCalculate = 1;
        }
        if (longest < length[2]) {
            longest = length[2];
            excludeCalculate = 2;
        }


        // 3) 나머지 길이의 합을 구하기
        for (int i = 0; i < 3; i++) {
            if (i == excludeCalculate) {
                continue;
            }
            notHypotenuseLength = notHypotenuseLength + length[i];
        }


        // 4) 3번에서 1을 뺀 값과 1번 중에 작은 값을 고르기
        perimeter = notHypotenuseLength;
        if (notHypotenuseLength <= longest) {
            perimeter = perimeter + (notHypotenuseLength - 1);
        } else {
            perimeter = perimeter + longest;
        }


        // 5) 4번과 나머지 길이의 합을 구하기
        System.out.println(perimeter);
    }
}