import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        // 1) 상근이가 가지고 있는 카드의 개수 N을 입력
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        // 2) 상근이가 가지고 있는 카드 입력
        List<Integer> cardList = new ArrayList<>();

        String[] tmp = br.readLine().split(" ");
        for (int i = 0; i < N; i++) {
            cardList.add(Integer.parseInt(tmp[i]));
        }


        // 3) 상근이가 가진 카드를 오름차순
        Collections.sort(cardList);


        // 3) 상근이가 가진 카드를 예측할 횟수
        int predictN = Integer.parseInt(br.readLine());


        // 4) 예측한 숫자 입력
        int[] predictCardList = new int[predictN];

        tmp = br.readLine().split(" ");
        for (int i = 0; i < predictN; i++) {
            predictCardList[i] = Integer.parseInt(tmp[i]);
        }



        for (int i = 0; i < predictN; i++) {
            int predict = predictCardList[i];

            int low = 0;
            int high = N - 1;
            int mid = (low + high) / 2;

            while (true) {
                // 5-1) 상근이가 가지고 있는 카드라면 1
                if (predict == cardList.get(mid)) {
                    predictCardList[i] = 1;
                    break;
                } else if (predict < cardList.get(mid)) {
                    high = mid - 1;
                    mid = (low + high) / 2;
                } else {
                    low = mid + 1;
                    mid = (low + high) / 2;
                }

                // 5-2) 가지고 있지 않은 카드라면 0
                if (low > high) {
                    predictCardList[i] = 0;
                    break;
                }
            }
        }


        // 6) 출력
        for (int i = 0; i < predictN; i++) {
            System.out.print(predictCardList[i] + " ");
        }
    }
}