import java.util.Arrays;
import java.util.stream.IntStream;

public class Intro2_Edge_of_the_Ocean {
    private static int adjacentElementsProduct(int[] inputArray){
        return IntStream.range(0,inputArray.length-1).map(i->inputArray[i]*inputArray[i+1]).max().getAsInt();
    }
    //입력된 배열의 인접한 요소의 곱중 max값을 출력
    //IntStream을 이용하여 간단하게 구현가능
    private static int shapeArea(int n) {
        return (int) (Math.pow(n,2) + Math.pow(n-1,2));
    }
    //테두리가 하나씩 증가하는 다이아몬드 모양의 n길이의 값을 구하라
    //제곱 pow함수를 통해 간단하게 구현가능.
    private static int makeArrayConsecutive2(int[] a){
        Arrays.sort(a);
        return a[a.length-1]-a[0]-a.length+1;
    }
    //배열에서 가장 큰수와 가장 작은수 사이에서 빠진 수의 개수를 출력
    //배열정렬(Arrays.sort)함수를 통해 간단하게 구현가능.
    private static boolean almostIncreasingSequence(int[] sequence){
        int var = 0;
        for(int i=0;i<sequence.length-1;i++){
            if(sequence[i]>=sequence[i+1]) var++;
            if(i+2<sequence.length && sequence[i]>=sequence[i+2]) var++;
        }
        return var<3;
    }
    //입력된 배열에서 한가지만 빼면 완전상승배열인지를 출력
    //체크변수를 잘 조절하여 간단하게 구현가능.
    
    public static void main(String[] args){
        int[] a  = {3, 6, -2, -5, 7, 3};
        int[] b = {6, 2, 3, 8};
        int[] c = {1,3,2,};
        System.out.println(adjacentElementsProduct(a));
        System.out.println(shapeArea(5));
        System.out.println(makeArrayConsecutive2(b));
        System.out.println(almostIncreasingSequence(c));

    }
}
