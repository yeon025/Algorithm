import java.io.*;
import java.util.*;


public class Main {

    public static void main(String[] args) {
        // 1) 보드의 길이 M N을 입력
        Scanner scanner = new Scanner(System.in);
        String[] array = scanner.nextLine().split(" ");
        int M = Integer.parseInt(array[0]);
        int N = Integer.parseInt(array[1]);


        // 2) MxN 길이의 보드판의 색을 입력
        List<String> board = new ArrayList<>();
        int chessLine = 0;
        char boardSpace;
        for (int i = 0; i < M; i++) {
            String boardRow = scanner.nextLine();
            while (chessLine < N) {
                boardSpace = boardRow.charAt(chessLine);
                board.add(String.valueOf(boardSpace));
                chessLine++;
            }
            chessLine = 0;
        }



        // 3) 체스판에 칠해야할 색이 있는지 확인하기 위해 제대로 칠해진 판을 생성
        String[] firstWhite = new String[64];
        String[] firstBlack = new String[64];
        int isWhite = 1;
        int isBlack = 1;

        for (int i = 0; i < 64; i++) {
            if (isWhite == 1) {
                firstWhite[i] = "W";
            } else {
                firstWhite[i] = "B";
            }
            isWhite = ~isWhite;

            if (i % 8 == 7) {
                isWhite = ~isWhite;
            }
        }

        for (int i = 0; i < 64; i++) {
            if (isBlack == 1) {
                firstBlack[i] = "B";
            } else {
                firstBlack[i] = "W";
            }
            isBlack = ~isBlack;

            if (i % 8 == 7) {
                isBlack = ~isBlack;
            }
        }


        List<String> chess = new ArrayList<>();
        int chessSpace = 0;
        int line = 0;
        int tmpWhiteColor = 0;
        int tmpBlackColor = 0;
        int leastColor = 10000;


        for (int j = 0; j < M * N; j++) {
            // 4) 8x8로 보드판을 자를 수 없는 경우
            if ((j % N) > N - 8) {
                continue;
            }
            if (j + N * 7 == M * N) {
                break;
            }


            // 5) 8x8씩 보드판을 자름
            for (int i = j; line < 8; i = i + N) {
                chessSpace = i;
                while (chessSpace < i + 8) {
                    // System.out.print(board.get(chessSpace) + " ");
                    chess.add(board.get(chessSpace));
                    chessSpace++;
                }
                line++;
                // System.out.println("chessSpace : " + chessSpace);
            }
            // System.out.println();


            // 6) 가장 적게 칠하는 경우의 수를 구함
            for (int i = 0; i < 64; i++) {
                if (!Objects.equals(chess.get(i), firstWhite[i])) {
                    tmpWhiteColor++;
                }
            }
            for (int i = 0; i < 64; i++) {
                if (!Objects.equals(chess.get(i), firstBlack[i])) {
                    tmpBlackColor++;
                }
            }

            if (tmpWhiteColor < leastColor) {
                leastColor = tmpWhiteColor;
            }
            if (tmpBlackColor < leastColor) {
                leastColor = tmpBlackColor;
            }

            tmpWhiteColor = 0;
            tmpBlackColor = 0;
            line = 0;
            chess = new ArrayList<>();
        }

        // 7) 가장 적게 칠하는 경우의 수를 출력
        System.out.println(leastColor);
    }
}