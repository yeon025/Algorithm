import java.util.*;

public class Main {
    public static void main(String[] args) {

        // 1) 변환할 수 N, B진법을 입력
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(" ");


        // 2) N의 문자열 길이를 구함
        int len = words[0].length();

        // 3) N의 각 자리수를 10진수로 변환
        List<Integer> toInt = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            if (words[0].charAt(i) >= 65) {
                toInt.add(words[0].charAt(i) - 55);
            } else {
                toInt.add(words[0].charAt(i) - '0');
            }
        }

        // 4) 10진수로 변환한 수 * B^문자열 길이
        // 5) 4의 결과를 모두 더함
        int result = 0;
        int formation = Integer.parseInt(words[1]);
        for (int i = 0; i < len; i++) {
            double tmp = toInt.get(i) * Math.pow(formation, len-i-1);
            result = result + (int)tmp;
        }

        // 6) 결과 출력
        System.out.println(result);
    }
}