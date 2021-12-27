import java.util.Arrays;
import java.util.HashMap;

public class marathon {


  class Solution {
    public String solution(String[] participant, String[] completion) {
      String answer = "";

      /* HashMap 사용
      * 중복된 키를 허용하지 않기때문에
      * 신규 등록되는 선수는 +1 (동명이인은 +1,...,+1)
      * 완주 선수는 -1 하며 완주의 경우 밸류값을 0으로 가지도록 함
      * */
      HashMap<String, Integer> hashMap = new HashMap<>();

      // 신규 등록되는 선수는 +1 (동명이인은 +1,...,+1)
      for (int i = 0; i < participant.length; i++) {

        hashMap.put(participant[i], hashMap.getOrDefault(participant[i],0)+1);

      } // for

      // 완주 선수는 -1
      for (int i = 0; i < completion.length; i++) {

        hashMap.put(completion[i], hashMap.get(completion[i])-1);

      } // for

      // vlaue값이 0이 아닌 선수 이름 가져오기
      for (int i = 0; i < participant.length; i++) {

        if(hashMap.get(participant[i]) !=0){
          answer = participant[i];
        } // if

      } // for




      /* Arrays 사용
      * 정렬 후 다른 값을 가졌을 경우 answer값에 넣고
      * answer값이 없다면 마지막 주자가 미완주라는 가정 */
      Arrays.sort(participant);
      Arrays.sort(completion);


      for (int i = 0; i < completion.length; i++) {
        answer = participant[participant.length-1];

        if(!participant[i].equals(completion[i])){
          answer=participant[i];
          break;
        } // if

      } // for


      return answer;
    }
  }


}
