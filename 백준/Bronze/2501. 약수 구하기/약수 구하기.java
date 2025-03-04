import java.util.*;



public class Main {

    public static void main(String[] args) {
        // 1) N과 K 입력
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");

        int N = Integer.parseInt(array[0]);
        int K = Integer.parseInt(array[1]);


        // 2) N의 약수를 배열에 저장
        List<Integer> factorList = new ArrayList<>();

        int i = 1;
        while (i <= N) {
            if (N % i == 0) {
                factorList.add(i);
            }
            i++;
        }

        
        // 3) 배열에서 K번째로 작은 수를 출력
        // System.out.println(factorList);
        try {
            System.out.println(factorList.get(K - 1));
        } catch (IndexOutOfBoundsException e) {
            System.out.println(0);
        }
    }
}