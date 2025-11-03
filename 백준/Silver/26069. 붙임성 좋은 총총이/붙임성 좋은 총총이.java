import java.io.*;
import java.util.*;


public class Main {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 사람들이 만난 기록 수 N 입력
        int N = Integer.parseInt(br.readLine());

        // 1 ~ N까지의 만난 사람을 입력
        ArrayList<String> people = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split(" ");
            people.add(inputs[0]);
            people.add(inputs[1]);
        }

        // ChongChong이 몇번째인지 체크
        int meetChongChong = 0;
        for (int i = 0; i < people.size(); i++) {
            if (Objects.equals(people.get(i), "ChongChong")) {
                if (i % 2 == 0) meetChongChong = i;
                else meetChongChong = i - 1;
                break;
            }
        }

        // ChongChong부터 중복되지 않는 이름을 셈
        Set<String> dancingPeople = new HashSet<>();
        dancingPeople.add(people.get(meetChongChong));
        dancingPeople.add(people.get(meetChongChong + 1));

        for (int j = meetChongChong + 2; j < people.size(); j = j + 2) {
            // people 중에 춤추고 있는 사람이 있는지 확인
            for (String dancingPerson : dancingPeople) {
                // people에 있는 사람과 춤추는 사람이 동일하면 그 옆 사람을 추가
                if (Objects.equals(people.get(j), dancingPerson)) {
                    dancingPeople.add(people.get(j + 1));
                    break;
                } else if (Objects.equals(people.get(j + 1), dancingPerson)) {
                    dancingPeople.add(people.get(j));
                    break;
                }
            }
        }

        // 출력
        bw.write(dancingPeople.size() + "\n");
        bw.flush();
    }
}