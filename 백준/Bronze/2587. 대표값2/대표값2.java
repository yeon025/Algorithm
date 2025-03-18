import java.util.*;


public class Main {

    public static void main(String[] args) {
        // 1) 5개의 자연수 입력
        Scanner scanner = new Scanner(System.in);
        List<Integer> numberList = new ArrayList<>();
        int tmp = 0;

        for (int i = 0; i < 5; i++) {
            tmp = scanner.nextInt();
            scanner.nextLine();
            numberList.add(tmp);
        }


        // 2) 평균 계산
        int sum = 0;
        int average = 0;

        for (int i = 0; i < 5; i++) {
            sum = sum + numberList.get(i);
        }
        average = sum / 5;


        // 3) 중앙값 계산
        Collections.sort(numberList);
        int median = numberList.get(2);

        
        // 4) 출력
        System.out.println(average);
        System.out.println(median);
    }
}