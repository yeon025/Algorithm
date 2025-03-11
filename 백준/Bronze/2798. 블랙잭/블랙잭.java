import java.util.*;


public class Main {

    public static void main(String[] args) {

        // 1) 펼칠 카드의 개수 N과 딜러가 외친 숫자 M을 입력
        Scanner scanner = new Scanner(System.in);
        String[] NM = scanner.nextLine().split(" ");
        int N = Integer.parseInt(NM[0]);
        int M = Integer.parseInt(NM[1]);


        // 2) N개의 카드에 쓰여진 수를 입력
        int toInt = 0;
        List<Integer> cardList = new ArrayList<>();
        String[] array = scanner.nextLine().split(" ");

        for(int i = 0; i < N; i++) {
            toInt = Integer.parseInt(array[i]);
            cardList.add(toInt);
        }


        // 3) 2번을 오름차순으로 정렬
        Collections.sort(cardList);
        // System.out.println(cardList);


        // 4) cardList의 수를 세 개씩 전부 더하기
        int sum = 0;
        List<Integer> sumList = new ArrayList<>();

        for(int i = 0; i < N - 2; i++) {
            for(int j = i + 1; j < N - 1; j++) {
                for(int k = j + 1; k < N; k++) {
                    sum = cardList.get(i) + cardList.get(j) + cardList.get(k);
                    sumList.add(sum);
                }
            }
        }


        // 5) 4번의 결과 중에서 M을 넘지 않고 가장 가까운 수를 출력
        Collections.sort(sumList);
        // System.out.println(sumList);
        

        for (int i = 0; i < sumList.size(); i++) {
            if (sumList.get(i) > M) {
                System.out.println(sumList.get(i - 1));
                return;
            }
            if (i == sumList.size() - 1) {
                System.out.println(sumList.get(i));
            }
        }
    }
}