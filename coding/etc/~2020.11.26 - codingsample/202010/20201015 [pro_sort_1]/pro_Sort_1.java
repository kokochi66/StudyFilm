import java.util.Arrays;

public class pro_Sort_1 {
    // https://programmers.co.kr/learn/courses/30/lessons/42748
    // 정렬의 첫번째문제 :: Level 1
    // 특정 위치를 정렬한 후, 특정 위치값을 뽑아옴.
    // 정렬에는 최악 n^2만큼의 복잡도를 필요로함.
    // 최대길이인 100에 갯수 50개 즉, 50만번의 최악 연산으로 구현이 가능함.
    public static int[] solution(int[] array, int[][] commands) {
        // 스트림을 사용하는 방법이 있지만 평범하게, 특정 위치값 배열을 별도로 적용하여 구현하도록 함.
        // 이렇게 되면 50번 만큼 100개의 배열을 도는 가능성이 있기 때문에, 5000번의 추가 연산이 필요함.
        // 연산을 줄이기 위해서는 동적계획처럼 정렬된 배열을 유지해주는 방법도 있으나, 현재 연산 수가 너무 크지 않으니 사용하지 않도록 함.
        int[] output = new int[commands.length];
        //출력값을 담을 output 배열을 선언

        for(int i=0;i<commands.length;i++){
            //commands의 배열을 돌며 i와 j를 뽑아 특정 배열안에 적용시킴.
            int[] temp = new int[commands[i][1]-commands[i][0]+1];
            for(int j=commands[i][0]-1;j<commands[i][1];j++){
                temp[j-(commands[i][0]-1)] = array[j];
            }
            Arrays.sort(temp);
            // temp 배열에 값을 적용시킨 후에, 해당 값을 정렬
            output[i] = temp[commands[i][2]-1];
            // 그리고 output에 각 해당하는 값을 저장시킴
        }
        return output;
    }

    public static void main(String[] args){
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] b = {
            {2,5,3},
            {4,4,1},
            {1,7,3}
        };
        System.out.println(Arrays.toString(solution(a, b)));
    }
}
