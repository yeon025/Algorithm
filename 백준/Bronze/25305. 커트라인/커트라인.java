import java.util.*;


public class Main {

    public static void main(String[] args) {
        // 1) 응시자 수 N과 수상 커트라인 k 입력
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int N = Integer.parseInt(array[0]);
        int k = Integer.parseInt(array[1]);


        // 2) 점수 입력
        String[] scoreArray = scanner.nextLine().split(" ");
        List<Integer> scoreList = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            scoreList.add(Integer.parseInt(scoreArray[i]));
        }


        // 3) 오름차순 정렬
        scoreList.sort(Collections.reverseOrder());

        
        // 5) 출력
        System.out.println(scoreList.get(k - 1));
    }
}