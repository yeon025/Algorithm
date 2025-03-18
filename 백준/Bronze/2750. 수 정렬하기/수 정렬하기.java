import java.util.*;


public class Main {

    public static void main(String[] args) {
        // 1) 입력할 횟수 N 입력
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        scanner.nextLine();


        // 2) N개의 숫자 입력
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int number = scanner.nextInt();
            numberList.add(number);
            scanner.nextLine();
        }


        // 3) 오름차순 정렬
        Collections.sort(numberList);


        // 4) 출력
        for (int i = 0; i < N; i++) {
            System.out.println(numberList.get(i));
        }
    }
}