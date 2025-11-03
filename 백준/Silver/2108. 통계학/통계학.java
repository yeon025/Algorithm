import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 숫자의 개수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 정수를 N번 입력
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(br.readLine());
            numbers.add(tmp);
        }
        Collections.sort(numbers);

        // 산술평균
        int sum = 0;
        for (int number : numbers) {
            sum = sum + number;
        }
        double average = (double) sum / N;
        bw.write(Math.round(average) + "\n");

        // 중앙값
        int middleIndex = N / 2;
        int middle = numbers.get(middleIndex);
        bw.write(middle + "\n");

        // 최빈값 (여러 개라면 두 번째로 작은 값)
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        int frequency = 1;
        for (int i = 0; i < N; i++) {
            if (i == N - 1) {
                frequencyMap.put(numbers.get(i), frequency);
                break;
            }

            if (Objects.equals(numbers.get(i), numbers.get(i + 1))) {
                frequency++;
            } else {
                frequencyMap.put(numbers.get(i), frequency);
                frequency = 1;
            }
        }

        // frequencyMap에서 최빈값으로 Map 재생성
        int max = Collections.max(frequencyMap.values());
        frequencyMap.values().removeIf(value -> value != max);

        // frequencyMap이 두 개 이상이라면 두 번째로 작은 키를 반환
        ArrayList<Integer> toList = new ArrayList<>(frequencyMap.keySet());
        Collections.sort(toList);
        if (toList.size() > 1) bw.write(toList.get(1) + "\n");
        else bw.write(toList.get(0) + "\n");

        // 최대값과 최소값의 차이
        int range = numbers.get(N - 1) - numbers.get(0);
        bw.write(range + "\n");

        // 출력
        bw.flush();
    }
}