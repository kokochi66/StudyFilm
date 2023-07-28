
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class KNUweek2 {
    //A는 0, B는 1...J는 9를 뜻하며 P는 더하기, S는 빼기, T는 곱하기, V는 나누기를 뜻한다. 
    private static int CalculAlpha(int op, int output, int temp) {    //연산자와 두 값을 받아 연산한 후 반환하는 함수
            if(op == 'P') output += temp;
            else if(op == 'S') output -= temp;
            else if(op == 'T') output *= temp;
            else if(op == 'V') output /= temp;
        return output;
    }
    public static void main(String[] args) throws Exception{
        Queue<Integer> op = new LinkedList<Integer>();
        Scanner sc = new Scanner(System.in);
        boolean startInt = false, ERR = false;;
        String input;
        int oper;
        int output, temp;
		while(sc.hasNextLine()){
            ERR = false;
            input = sc.nextLine();
            output = 0;
            temp = 0;
            for(int i=0;i<input.length();i++){
                if(input.charAt(i)-'A' >=0 && input.charAt(i)-'A' <=9){           //정수인경우
                    if(startInt) output = (output*10) + (int)(input.charAt(i)-'A');
                    else output = (int)(input.charAt(i)-'A');
                    startInt = true;
                    // System.out.println("정수 입력 " + output);
                }
                else if(input.charAt(i) == 'P' || input.charAt(i) == 'S' || input.charAt(i) == 'T' || input.charAt(i) == 'V'){   //연산자나 마지막 수 인경우
                    if(!startInt || i==input.length()-1){                   //정수가 나오지도 않았는데 연산자가 나온경우 에러
                        ERR = true;
                        break;
                    }
                    if(op.peek() != null) temp = CalculAlpha(op.poll(),temp,output);  //이미 연산자가 있을경우 연산해줌.
                    else temp = output;
                    op.offer((int)input.charAt(i));  //연산자 큐에 해당 연산자를 넣어줌.
                    // System.out.println("연산자 들어감 " + op.peek());
                    startInt = false;
                }
                else {              //정해진 수나 연산자가 나오지 않을경우 에러
                    ERR = true;
                    break;
                }
            }
            // System.out.println("반복 끝, 마지막연산 " + op.peek() + " " + output + " " + temp);
            if(op.peek() != null && !ERR) output = CalculAlpha(op.poll(),temp,output);     //수가 끝났을때, 마지막 연산을 해줌
            if(op.peek() != null || ERR) System.out.println("Error");                      // 마지막연산까지 했는데 연산자가 남아있으면 에러
            else System.out.println(output);
            while(op.peek() != null) op.poll();         // 큐를 비워줌.
        }

    }
    
}
