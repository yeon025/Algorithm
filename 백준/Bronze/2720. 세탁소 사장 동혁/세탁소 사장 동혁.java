import java.util.*;

public class Main {

    public static void main(String[] args) {
        // 1) 테스트 케이스 개수 T 입력
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        // 2) 거스름돈을 T번 입력
        List<Integer> changeList = new ArrayList<>();
        for (int i = 0; i < T; i++) {
            int getChange = scanner.nextInt();
            changeList.add(getChange);
        }

        // 3) T개만큼 배열을 생성하고 배열에 필요한 동전의 개수를 저장하게 함
        List<Integer> coinList = new ArrayList<>();

        // 4) "거스름돈 / 동전"으로 몇 개의 동전이 필요한지 계산
        int change;
        for (int i = 0; i < T; i++) {
            change = changeList.get(i);

            int quarterCount = change / 25;
            change = change - 25 * quarterCount;
            coinList.add(quarterCount);

            int dimeCount = change / 10;
            change = change - 10 * dimeCount;
            coinList.add(dimeCount);

            int nickelCount = change / 5;
            change = change - 5 * nickelCount;
            coinList.add(nickelCount);

            int pennyCount = change;
            coinList.add(pennyCount);
        }

        // 5) 결과 출력
        for (int i = 0; i < T; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(coinList.get(4 * i + j) + " ");
            }
            System.out.println();
        }
    }
}