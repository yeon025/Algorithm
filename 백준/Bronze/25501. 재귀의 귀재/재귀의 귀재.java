import java.io.*;
import java.util.*;



class PR {
    int isPalindrome;
    int recursionCount;

    public PR (int isPalindrome, int recursionCount) {
        this.isPalindrome = isPalindrome;
        this.recursionCount = recursionCount;
    }
}

public class Main {

    static int count = 0;

    public static int recursion(String s, int l, int r){
        count++;

        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }

    public static int isPalindrome(String s){
        count = 0;
        return recursion(s, 0, s.length()-1);
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // N 입력
        int N = Integer.parseInt(br.readLine());

        // N번 단어 입력
        String[] words = new String[N];
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }

        // 계산
        PR[] list = new PR[N];
        int i = 0;
        for (String word : words) {
            PR tmp = new PR(isPalindrome(word), count);
            list[i] = tmp;
            i++;
        }

        // 출력
        for (PR tmp : list) {
            bw.write(tmp.isPalindrome + " " + tmp.recursionCount + "\n");
        }
        bw.flush();
    }
}