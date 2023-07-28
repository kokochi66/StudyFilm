import java.util.*;
public class KNU_week5_e2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int CaseInteger;
        String InputString = sc.nextLine();
        int CaseNumber = 1;
        boolean Wrong = false;
        boolean Presented = false;
        while(!InputString.equals("0")){
            Wrong = false;
            Presented = false;
            // System.out.println(CaseNumber +"번 케이스 시작합니다.");
            CaseInteger = Integer.parseInt(InputString);
            LinkedList<String> Right = new LinkedList<String>();
            for(int TestCase = 0; TestCase < CaseInteger; TestCase++ ){
                InputString = sc.nextLine();
                Right.add(InputString);
            }
            // System.out.println("정답이 입력이 완료되었습니다.");
            InputString = sc.nextLine();
            CaseInteger = Integer.parseInt(InputString);
            LinkedList<String> Answer = new LinkedList<String>();
            for(int TestCase = 0; TestCase < CaseInteger; TestCase++ ){
                InputString = sc.nextLine();
                Answer.add(InputString);
            }
            // System.out.println("문제가 입력이 완료되었습니다.");
            while(!Right.isEmpty()){
                if(!(Right.get(0).equals(Answer.get(0)))) {
                    if(Right.get(0).length() != Answer.get(0).length()) {
                        Presented = true;
                        break;
                    }
                    for(int i=0;i<Right.get(0).length();i++){
                        if(Right.get(0).charAt(i) != Answer.get(0).charAt(i)){
                            if(Right.get(0).charAt(i)>='0' && Right.get(0).charAt(i)<='9' && 
                            Answer.get(0).charAt(i)>='0' && Answer.get(0).charAt(i)<='9'){
                                Wrong = true;
                            }
                            else Presented = true;
                            break;
                        }
                    }
                }
                Right.remove(0);
                Answer.remove(0);
            }
            if(Presented) System.out.println("Run #"+CaseNumber+": Presentation Error");
            else if(Wrong) System.out.println("Run #"+CaseNumber+": Wrong Answer");
            else System.out.println("Run #"+CaseNumber+": Accepted");
            InputString = sc.nextLine();
            CaseNumber++;
        }
    }
}
