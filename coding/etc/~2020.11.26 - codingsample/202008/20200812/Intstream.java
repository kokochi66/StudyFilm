package Edge_of_the_Ocean;

import java.util.stream.IntStream;

public class Intstream {
	public static void main(String[] args) {
		int[] a = {1,2,3,4,5};
		//Intstream의 일부 사용법에 대해 기재
		System.out.println(IntStream.range(1,5).sum());
		// range->sum a~b-1까지 반복/ sum= 합
		System.out.println(IntStream.rangeClosed(1, 5).sum());
		// rangeClosed->sum a~b까지 반복
		System.out.println(IntStream.range(1,5).map(i->a[i]*a[i-1]).max().getAsInt());
		System.out.println(IntStream.range(1,5).map(i->a[i]*a[i-1]).min().getAsInt());
		// map i->[] range범위에서 map으로 결정되는 값을 하나씩 꺼냄
		// max -> 그 값들 중 최댓값을 선정, min-> 값들 중 최솟값을 선정
		// getAsInt 해당 값을 정수로 받아옴.
		
	}

}
