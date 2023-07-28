package Smooth_Sailing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;

public class Stream {
	public static void main(String[] args) {
		String[] inputArray = {"abg","aa","ad","vcd","aba","goaz","hfddfg"};
		
		String[] output = Arrays.stream(inputArray)
		        .filter(i->i.length()==IntStream.range(0,inputArray.length).map(j->inputArray[j].length())
		        .max().getAsInt()).toArray(String[]::new);
	
		for(int i=0;i<output.length;i++) System.out.print(output[i]+" ");
		System.out.println();
		
		int max_len = Arrays.stream(inputArray).max(Comparator.comparingInt(String::length)).get().length();
		output = Arrays.stream(inputArray).filter(x -> x.length() == max_len).toArray(String[]::new);
		for(int i=0;i<output.length;i++) System.out.print(output[i]+" ");
		System.out.println();
		
		String s =Arrays.stream(inputArray).max(Comparator.comparingInt(String::length)).get();
		System.out.println(s);
		
		output = Arrays.stream(inputArray).sorted(Comparator.comparingInt(String::length)).toArray(String[]::new);
		for(int i=0;i<output.length;i++) System.out.print(output[i]+" ");
		System.out.println();
		
//스트림의 기본 사용법
//원소를 가공하는 방법 - map, filter, sorted
//map : 요소들을 특정 조건에 해당하는 값으로 변환
//filter : 요소들을 조건에 따라 걸러내는 작업을 함
//sorted : 요소들을 정렬함
//가공이 끝난 값은 collect를 통해 리턴값을 정해줌
//현재 output은 두가지 모두 filter를 통해 만들어짐.
//
//1번 예제를 먼저 봄. 1번예제에서는 filter안에 map이 들어가있는 형태임
//첫번째 구문
//Arrays.stream(inputArray).filter
//:: inputArray라는 배열에서
//
//i->i.length()==IntStream.range(0,inputArray.length)
//:: IntStream.range를 사용하여, 0부터 inputArray.length까지 반복한다.
//:: 여기서부터는 IntStream의 구문들이다.
//
//.map(j->inputArray[j].length()).max().getAsInt()
//:: inputArray의 길이중 max, 즉 최대값을 가지는 수를 getAsInt를 통해 정수값으로 받음.
//:: 즉, 위의 조건과 합하여 inputArray의 배열 내에서 문자열의 길이가 배열 전체를 반복해서, max값을 갖는 값과 ==로 일치하는 i문자열을 가져옴
//
//toArray(String[]::new)
//:: 마지막으로 해당값을 toArray(String[]::new) 를 통해
//:: 새로운 문자열 배열로써 반환함.
//:: 이를 통해 문자열배열 내에서 가장 길이가 긴 문자열들 만이 반환됨.
//		
//2번 예제
//2번예제는 먼저 max값을 IntStream으로 한 구문안에 정의하지 않고, int변수를 만들어 해당값에 먼저 집어넣음.
//Arrays.stream(inputArray)
//:: inputArray라는 배열에서
//
//.max(Comparator.comparingInt(String::length))
//:: Compartor에 comparingInt를 사용하여, 해당 배열에서 String의 length를 비교하여 max값에 해당하는 문자열을 반환함.
//
//.get().length()
//:: 그리고 해당값을 get으로 반환하고, 그 문자열의 length를 정수로 int max에 저장해줌.
//
//그 다음으로 배열에서는 또한 filter를 이용해서
//.filter(x -> x.length() == max_len)
//로 해당 max_len에 해당하는 문자열값을 toArray(String[]::new)를 통해 문자열 배열로써 반환함.


	}

}
