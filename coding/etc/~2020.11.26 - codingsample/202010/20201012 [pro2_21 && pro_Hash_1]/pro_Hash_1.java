import java.util.HashMap;

public class pro_Hash_1 {
    //지금까지 푼 문제들을 너무 대충 푼 것 같아서 재정리 시작.
    //하루에는 무조건 딱 한 문제만 푸는것으로 하며, 대신 해당 문제에 대해 깊게 파고드는 것이 필요함.
    // https://programmers.co.kr/learn/courses/30/lessons/42576

    public static String solution(String[] participant, String[] completion) {
        // 배열의 길이는 최대 100,000이기 때문에, 제곱연산 시, 100억 연산으로 불가능함 [천만 연산 미만으로 풀어내는것이 목표]
        // 하지만 배열이 기본적으로 섞여있기 때문에, 모든 배열을 확인할 필요가 있음 -> 2n 이상의 연산이 필요함.
        HashMap<String, Integer> compSet = new HashMap<String, Integer>();
        
        for(int i=0;i<completion.length;i++) {
            if(compSet.containsKey(completion[i])) compSet.put(completion[i], compSet.get(completion[i])+1);
            else compSet.put(completion[i], 1);
        }
        //  1) 완료한 인원들을 모두 key값의 스트링으로 넣는다. value값은 1로 넣는다 [n연산 = 100,000]
        //      만약 같은 이름이 있을 경우, value 값을 +1 한다.

        for(int i=0;i<participant.length;i++) {
            if(compSet.containsKey(participant[i])) {
                if(compSet.get(participant[i])==1) compSet.remove(participant[i]);
                else compSet.put(participant[i], compSet.get(participant[i])-1);
            }
            else return participant[i];
        }
        //  2) 참가한 인원들을 partSet으로 서칭한다 [n연산 = 100,000]
        //      HashMap에서 해당 String을 포함하고 있을 경우, value를 -1 하며, value가 1이면 값을 제거한다.
        //      해당 String이 없을경우, 해당 String을 반환한다.

        // 총합 연산 : 약 2n(200,000) (실제 자료구조 활용구조를 생각하면 사실 훨씬 클 수 있음)

        return "[ERROR]";
        //  모든 참가한 인원들을 서칭하면 리턴값이 나와야 정상이다. 나오지 않았다면 ERROR를 리턴한다.
    }

    public static void main(String[] args){
        String[] a = {"marina", "josipa", "nikola", "vinko", "filipa"};
        String[] b = {"josipa", "filipa", "marina", "nikola"};
        System.out.println(solution(a,b));
    }
    
}
