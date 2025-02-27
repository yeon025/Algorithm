import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Integer> convertList = new ArrayList<>();
        int tmpRemainder = 0;
        int getConvertList = 0;
        String listToString = "";
        String result = "";


        // 1) 10진수 N, 변환할 B진법을 입력
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] words = input.split(" ");


        // 2) N을 B로 나눈 몫을 구함
        int quotient = Integer.parseInt(words[0]) / Integer.parseInt(words[1]);


        // 3) N을 B로 나눈 나머지를 구함
        int remainder = Integer.parseInt(words[0]) % Integer.parseInt(words[1]);


        // 4) 나머지를 배열에 저장
        convertList.add(remainder);


        // 5) 몫이 더 이상 나눠지지 않을 때까지 계속 연산
        while (quotient >= Integer.parseInt(words[1])) {
            tmpRemainder = quotient % Integer.parseInt(words[1]);
            quotient = quotient / Integer.parseInt(words[1]);
            convertList.add(tmpRemainder);
        }
        convertList.add(quotient);


        // 6) 배열 반전
        Collections.reverse(convertList);


        // 7) B진법으로 변환
        for (int i = 0; i < convertList.size(); i++) {
            getConvertList = convertList.get(i);

            if (getConvertList > 9) {
                listToString = listToString + (char)(getConvertList + 55);
            } else {
                listToString = listToString + (char)(getConvertList + 48);
            }
        }


        // 8) 맨 앞자리의 0 제거
        result = listToString.replaceFirst("^0+", "");

        if (result.isEmpty()) {
            result = "0";
        }


        // 9) 결과 출력
        System.out.println(result);
    }
}