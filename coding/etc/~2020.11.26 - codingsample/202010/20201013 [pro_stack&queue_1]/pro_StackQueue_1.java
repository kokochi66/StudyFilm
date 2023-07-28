import java.util.Arrays;
import java.util.Stack;

public class pro_StackQueue_1 {
    // https://programmers.co.kr/learn/courses/30/lessons/42584
    // 주식 가격문제.
    // 각 배열의 위치를 기준으로, 가격이 떨어지지 않은 시간을 기록한 배열을 리턴함.
    // 여전히 10,000,000(천만)연산 미만으로 문제를 해결하는것을 목표로 함.

    public static int[] solution(int[] prices) {
        // 스택을 이용한 방법으로, 배열을 순회하며 n번(100,000번)연산, 스택에서 빼내는 n번(100,000번)연산으로 2n연산으로 가능함.
        // 기본적으로 스택의 끝에 오는 수를 현재 진행되고있는 값의 최댓값으로 지정함.
        // 예를들어, 1이오고 2가오고 3이오면 3이 스택의 최댓값이 오게됨.
        // 만약에 1이오고 3이오고 2가 올 경우, 스택의 끝값 중에 2보다 큰 값을 리턴하며 지정하기 때문에 문제가 없음.
        // 만약 1, 3, 3으로 같은값이 연속해서 올 경우, 가격이 떨어진 것이 아니므로 스택을 유지함.
        // 다만 문제는 output하는 배열의 위치를 어떻게 지정할지가 문제임. (2개짜리 정수배열로 swit까지 함께 저장하는 방법이 있긴함 => 해당방법으로 시행)

        Stack<Integer[]> save = new Stack<Integer[]>();
        // 스택을 정수배열로 선언, 저장될 정수배열은 0에 prices 값을 저장하며, 1에 output에 저장될 swit이 저장되는 2개짜리 정수배열임.
        int[] output = new int[prices.length];
        // 출력으로 사용될 output 배열 선언.

        for(int i=0;i<prices.length;i++){
            if((!save.isEmpty() && save.peek()[0] > prices[i]) || (i == prices.length-1)){
                // 먼저 스택 안에 값이 비어있는지 확인해야함 (오류 방지)
                // 그 뒤에, 스택의 최대 prices값이 현재 prices값보다 큰지 확인.
                // 혹은 순환이 최대치에 도달한 경우(배열은 끝났는데, 스택이 남아있을 수 있음.)
                while(!save.isEmpty() && ((save.peek()[0] > prices[i]) || (i == prices.length-1))) {
                    // 크다면 스택의 내부 값을 계속 순환하며 현재 price보다 큰 값을 전부 꺼냄.
                    // 순환 최대치인 경우에는, 그냥 남은 스택을 전부 반환함.
                    int peek1 = save.peek()[1];
                    output[peek1] = i-peek1;
                    save.pop();
                    // 초의 수는 (현재 초) - (해당 배열의 초) 값이 됨.
                }
                if(i!=prices.length-1) save.add(new Integer[]{prices[i],i});
                else output[i] = 0;
                // 해당 값이 마지막값이 아니면, 현재 값을 스택에 넣어주며, 마지막값이면 해당 마지막값에 0을 넣고 반환
            }
            else {
                save.add(new Integer[]{prices[i],i});
                // 스택이 비어있거나, 현재 스택의 끝값보다 현재 price값이 더 크거나 같을 경우에는 스택에 값을 추가해준다.
            }
        }

        return output;
    }

    public static void main(String[] args){
        int[] a = {1,2,3,2,3};
        System.out.println(Arrays.toString(solution(a)));
    }
}
