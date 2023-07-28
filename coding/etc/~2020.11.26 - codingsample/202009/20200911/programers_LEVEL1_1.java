import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.stream.IntStream;

public class programers_LEVEL1_1 {
    public static int solution(int[][] board, int[] moves) {
        Stack<Integer> st = new Stack<Integer>();
        int answer = 0;
        for(int i=0;i<moves.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[j][moves[i]-1] != 0){
                    if(!st.empty() && st.peek() == board[j][moves[i]-1]) {
                        answer += 2;
                        st.pop();
                    }
                    else st.push(board[j][moves[i]-1]);
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }
        return answer;
    }

    public static String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for(int i=0;i<completion.length;i++){
            if(!completion[i].equals(participant[i])) return participant[i];
        }
        return participant[participant.length-1];
    }

    public static int[] solution3(int[] answers) {
        int[] per1 = {1,2,3,4,5};
        int[] per2 = {2,1,2,3,2,4,2,5};
        int[] per3 = {3,3,1,1,2,2,4,4,5,5};
        int score1 = 0, score2 = 0, score3 = 0;
        for(int i=0;i<answers.length;i++){
            if(per1[i%(per1.length)] == answers[i]) score1++;
            if(per2[i%(per2.length)] == answers[i]) score2++;
            if(per3[i%(per3.length)] == answers[i]) score3++;
        }
        System.out.println(score1 + " " + score2 + " " + score3);
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(score1 >= score2 && score1 >= score3) list.add(1);
        if(score2 >= score1 && score2 >= score3) list.add(2);
        if(score3 >= score1 && score3 >= score2) list.add(3);
        return IntStream.range(0, list.size()).map(i->list.get(i)).toArray();
    }
    public static void main(String[] args){
        int[][] a = {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}};
        int[] b = {1, 5, 3, 5, 1, 2, 1, 4};
        System.out.println(solution(a,b));
        
        String[] a2 = {"leo", "kiki", "eden"};
        String[] b2 = {"eden", "kiki"};
        System.out.println(solution2(a2,b2));

        int[] a3 = {1,3,2,4,2};
        System.out.println(Arrays.toString(solution3(a3)));
    }
    
}
