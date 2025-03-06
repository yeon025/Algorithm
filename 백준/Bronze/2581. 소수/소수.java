import java.util.*;


public class Main {

    public static void main(String[] args) {

        // 1) M, N 두 개의 자연수를 입력
        Scanner scanner = new Scanner(System.in);
        int M = scanner.nextInt();
        scanner.nextLine();
        int N = scanner.nextInt();

        
        // 2) M 이하 N 이상의 수에서 소수를 찾음
        int factor = 2;
        List<Integer> primeNumberList = new ArrayList<>();

        while (M <= N) {
            while (factor < M) {
                if (M % factor == 0) {
                    break;
                }
                factor++;
            }
            if (factor == M) {
                primeNumberList.add(M);
            }
            M++;
            factor = 2;
        }
        

        // 3) 2에서 찾은 소수의 합을 구함
        int addPrimeNumber = 0;
        for (int number : primeNumberList) {
            addPrimeNumber = addPrimeNumber + number;
        }

        
        // 3-1) 첫째 줄에 2에서 찾은 소수의 합을 출력
        // 3-2) 둘째 줄에 2에서 찾은 소수의 최소값을 출력
        // 3-3) 소수가 없다면 -1 출력
        if (!primeNumberList.isEmpty()) {
            System.out.println(addPrimeNumber);
            System.out.println(primeNumberList.get(0));
        } else {
            System.out.println(-1);
        }
    }
}