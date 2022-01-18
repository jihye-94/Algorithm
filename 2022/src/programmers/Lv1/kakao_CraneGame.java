package programmers.Lv1;

import java.util.Stack;


class kakao_CraneGame {

  public static void main(String[] args) {

    int[][] a = {
        {0, 0, 0, 0, 0},
        {0, 0, 1, 0, 3},
        {0, 2, 5, 0, 1},
        {4, 2, 4, 4, 2},
        {3, 5, 1, 3, 1}
    };

    int[] moves = {1, 5, 3, 5, 1, 2, 1, 4};

    craneGame(a, moves);

  } // main

  public static int craneGame(int[][] board, int[] moves) {

      int answer = 0;

      Stack<Integer> stack = new Stack<Integer>();

      for (int move : moves) {

        for (int j = 0; j < board.length; j++) {

          /*
          * 칸에 인형이 존재하는 경우(!=0)
          * 다음 행(아래로)으로 이동함 [0][0], [1][0], [2][0]
          *
          * move배열 원소 값을 board 2차원배열의 열 값에 넣어 비교(board[j][move-1])하며
          * 배열 인덱스는 0부터 시작이니까 -1
          * */

          if (board[j][move - 1] != 0) {

            // 스택이 비어있으면 해당 칸의 숫자(==인형)를 넣기 push
            if (stack.isEmpty()) {
              stack.push(board[j][move - 1]);

              // 스택이 비어있지않다면(==인형이 들어있다면)
            } else {

              // 들어있는 인형과 새로 뽑은 인형 값이 동일하면 pop 제거하고 ansewer +2
              if (stack.peek() == board[j][move - 1]) {
                stack.pop();
                answer += 2;

                // 동일하지 않다면 바구니(move)에 인형 넣기 push
              } else {
                stack.push(board[j][move - 1]);
              } // if-else

            } // if-else

            // 인형을 넣었으니까 해당 칸의 값 0으로 만들기
            board[j][move - 1] = 0;
            break;

          } // if
        } // for
      } // for

      System.out.println(answer);
      return answer;

  }


}


