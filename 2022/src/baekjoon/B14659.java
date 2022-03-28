package baekjoon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*
 * 첫째 줄에 봉우리의 수 겸 활잡이의 수 N이 주어진다. (1 ≤ N ≤ 30,000)
 * 둘째 줄에 N개 봉우리의 높이가 왼쪽 봉우리부터 순서대로 주어진다. (1 ≤ 높이 ≤ 100,000)
 * 각각 봉우리의 높이는 중복 없이 유일하다.


 *
 * */
public class B14659 {
  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    int count = sc.nextInt();
    String mHighList = sc.nextLine();



    solution(count, mHighList );


  }

  public static int answer = Integer.MIN_VALUE;

  public static void solution(int a, String mList){

    System.out.println("=======================");

    System.out.println("a= "+ a);
    System.out.println("mList= "+ mList);

    String[] separatedStrings = mList.split(" "); // String 배열에 담고

    int[] mArr = new int[separatedStrings.length]; // int 배열로 전환

    for (int i = 0; i < separatedStrings.length; i++) { // int 배열에 잘 담기

      try {
        mArr[i] = Integer.parseInt(separatedStrings[i]);
      } catch (Exception e) {
        System.out.println("Unable to parse string to int: " + e.getMessage());
      }
    }

    System.out.println("mArr= "+Arrays.toString(mArr));

    int temp = 0;
    for (int i = 0; i < mArr.length-1; i++) {
      for (int j = 0; j < i; j++) {
        int count = 0;

        if(mArr[j] > mArr[j+1]){ // 두번째 숫자가 더 작으면


          count++; // 카운트 해주고

        } else{
          break;
        }

        answer = Math.max(answer, count); // 큰 수로 변경

      }
    }

    System.out.println(answer);






  }
}
