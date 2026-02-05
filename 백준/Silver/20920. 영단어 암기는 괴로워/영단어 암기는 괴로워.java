import java.io.*;
import java.util.*;


class WordList {
    String word;
    int frequency;
    int length;

    WordList(String word, int frequency, int length) {
        this.word = word;
        this.frequency = frequency;
        this.length = length;
    }

    public String getWord() {
        return word;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getLength() {
        return length;
    }
}


public class Main {

    static WordList[] newList;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        // 단어 개수 N, 단어 길이 M 입력
        String[] splited = br.readLine().split(" ");
        int N = Integer.parseInt(splited[0]);
        int M = Integer.parseInt(splited[1]);


        // 단어 입력 및 M 이상의 단어만 저장
        ArrayList<String> words = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            if (input.length() >= M) words.add(input);
        }
        Collections.sort(words);


        // 단어의 빈도수, 길이를 구조체로 저장
        ArrayList<WordList> list = new ArrayList<>();
        int frequency = 1;

        for (int i = 0; i < words.size(); i++) {
            if (i + 1 < words.size() && words.get(i).equals(words.get(i + 1))) {
                frequency++;
                continue;
            }

            list.add(new WordList(words.get(i), frequency, words.get(i).length()));

            frequency = 1;
        }


        // 배열로 변환
        newList = list.toArray(WordList[]::new);


        // 빈도수, 길이, 알파벳 사전 순으로 배치
        Arrays.sort(newList, (a, b) -> {
            if (a.getFrequency() != b.getFrequency())
                return b.getFrequency() - a.getFrequency();

            if (a.getLength() != b.getLength())
                return b.getLength() - a.getLength();

            return a.getWord().compareTo(b.getWord());
        });


        // 출력
        for (WordList detail : newList) {
            bw.write(detail.getWord() + "\n");
        }
        bw.flush();
    }
}