import java.util.Arrays;
import java.util.LinkedList;

public class pro_Brute_1 {
    // https://programmers.co.kr/learn/courses/30/lessons/42840
    // 주어진 배열 내에서 특정 배열값과 일치하는 값이 몇개나 있는지를 체크하는 함수.
    // 주어진 배열 n(최대 10,000) 만큼의 연산이 최소로 필요함.
    // 여기서 문제 푸는 것 자체에 연연하기보다 배열을 조금먹고 구현하는 방법을 생각해봄.

    // 우선 주어진 3개의 기본배열 구현이 필요함.
    // 각 3개의 기본배열에 해당하는 Score값을 저장할 값도 필요함
    // 여기서 리스트로 최대값을 저장하는 배열을 뽑아내는것이 바람직할 수 있음.
    public static int[] solution(int[] answers) {
        int[] st1 = {1,2,3,4,5};
        int[] st2 = {2,1,2,3,2,4,2,5};
        int[] st3 = {3,3,1,1,2,2,4,4,5,5};
        int[] score = new int[3];
        Arrays.fill(score, 0);
        for(int i=0;i<answers.length;i++){
            System.out.println(i%5 +"  "+ i%8 +"   "+i%10);
            if(st1[i%5] == answers[i]) score[0]++;
            if(st2[i%8] == answers[i]) score[1]++;
            if(st3[i%10] == answers[i]) score[2]++;
        }

        LinkedList<Integer> output = new LinkedList<Integer>();
        if(score[0] >= Math.max(score[1], score[2])) output.add(1);
        if(score[1] >= Math.max(score[0], score[2])) output.add(2);
        if(score[2] >= Math.max(score[1], score[0])) output.add(3);
        int[] outputarr = new int[output.size()];
        for(int i=0;i<output.size();i++) outputarr[i] = output.get(i);
        return outputarr;
    }
    public static void main(String[] args){
        int[] a = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
        System.out.println(Arrays.toString(solution(a)));
    }
}
